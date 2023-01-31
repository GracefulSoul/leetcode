package gracefulsoul.problems;

import java.util.Arrays;

public class BinaryTreesWithFactors {

	// https://leetcode.com/problems/binary-trees-with-factors/submissions/888747996/
	public static void main(String[] args) {
		BinaryTreesWithFactors test = new BinaryTreesWithFactors();
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4 }));
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));
	}

	public int numFactoredBinaryTrees(int[] arr) {
		int mod = 1000000007;
		int length = arr.length;
		long[] dp = new long[length];
		Arrays.fill(dp, 1);
		Arrays.sort(arr);
		long result = 0;
		for (int idx = 1; idx < length; idx++) {
			int left = 0;
			int right = idx - 1;
			while (left <= right) {
				long product = 1l * arr[left] * arr[right];
				if (product == arr[idx]) {
					dp[idx] += dp[left] * dp[right];
					if (arr[left] != arr[right]) {
						dp[idx] += dp[left] * dp[right];
					}
					left++;
					right--;
				} else if (product < arr[idx]) {
					left++;
				} else {
					right--;
				}
			}
		}
		for (long num : dp) {
			result += num;
		}
		return (int) (result % mod);
	}

}
