package gracefulsoul.problems;

import java.util.Arrays;

public class KthSmallestAmountWithSingleDenominationCombination {

	// https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/submissions/2115044257/
	public static void main(String[] args) {
		KthSmallestAmountWithSingleDenominationCombination test = new KthSmallestAmountWithSingleDenominationCombination();
		System.out.println(test.findKthSmallest(new int[] { 3, 6, 9 }, 3));
		System.out.println(test.findKthSmallest(new int[] { 5, 2 }, 7));
	}

	public long findKthSmallest(int[] coins, int k) {
		Arrays.sort(coins);
		int[] dp = new int[coins.length];
		int n = 0;
		for (int coin : coins) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (coin % dp[j] == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				dp[n++] = coin;
			}
		}
		long left = k;
		long right = (long) dp[0] * k;
		while (left < right) {
			long mid = left + (right - left) / 2;
			if (this.check(mid, dp, n, k)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean check(long mid, int[] dp, int n, int k) {
		long result = 0;
		for (int i = 1; i <= n; i++) {
			int num = (1 << i) - 1;
			while (num < (1 << n)) {
				long x = 1;
				for (int j = 0; j < n; j++) {
					if (((num >> j) & 1) != 0) {
						x = (x / this.getGcd(x, dp[j])) * dp[j];
					}
				}
				result += (mid / x) * (((i & 1) << 1) - 1);
				int bit = num & -num;
				int sum = num + bit;
				num = (((sum ^ num) >> 2) / bit) | sum;
			}
		}
		return result >= k;
	}

	private long getGcd(long m, long n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
