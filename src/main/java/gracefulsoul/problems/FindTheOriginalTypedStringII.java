package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindTheOriginalTypedStringII {

	// https://leetcode.com/problems/find-the-original-typed-string-ii/submissions/1683740788/
	public static void main(String[] args) {
		FindTheOriginalTypedStringII test = new FindTheOriginalTypedStringII();
		System.out.println(test.possibleStringCount("aabbccdd", 7));
		System.out.println(test.possibleStringCount("aabbccdd", 8));
		System.out.println(test.possibleStringCount("aaabbb", 3));
	}

	private static final int MOD = 1000000007;

	public int possibleStringCount(String word, int k) {
		if (word.length() == k) {
			return 1;
		}
		List<Integer> list = new ArrayList<>();
		int n = word.length();
		int i = 0;
		while (i < n) {
			int j = i + 1;
			while (j < n && word.charAt(j) == word.charAt(j - 1)) {
				j++;
			}
			list.add(j - i);
			i = j;
		}
		int size = list.size();
		long[] power = new long[size];
		power[size - 1] = list.get(size - 1);
		for (i = size - 2; i >= 0; i--) {
			power[i] = (power[i + 1] * list.get(i)) % MOD;
		}
		if (size >= k) {
			return (int) power[0];
		}
		long[][] dp = new long[size][k - size + 1];
		for (i = 0; i < k - size + 1; i++) {
			if (list.get(size - 1) + i + size > k)
				dp[size - 1][i] = list.get(size - 1) - (k - size - i);
		}
		for (i = size - 2; i >= 0; i--) {
			long sum = (dp[i + 1][k - size] * list.get(i)) % MOD;
			for (int j = k - size; j >= 0; j--) {
				sum += dp[i + 1][j];
				if (j + list.get(i) > k - size) {
					sum = (sum - dp[i + 1][k - size] + MOD) % MOD;
				} else {
					sum = (sum - dp[i + 1][j + list.get(i)] + MOD) % MOD;
				}
				dp[i][j] = sum;
			}
		}
		return (int) dp[0][0];
	}

}
