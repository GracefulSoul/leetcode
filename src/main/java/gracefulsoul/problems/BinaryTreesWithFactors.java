package gracefulsoul.problems;

import java.util.Arrays;

public class BinaryTreesWithFactors {

	// https://leetcode.com/problems/binary-trees-with-factors/submissions/1084541556/
	public static void main(String[] args) {
		BinaryTreesWithFactors test = new BinaryTreesWithFactors();
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4 }));
		System.out.println(test.numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));
	}

	public int numFactoredBinaryTrees(int[] arr) {
		int length = arr.length;
		long[] dp = new long[length];
		Arrays.fill(dp, 1);
		Arrays.sort(arr);
		long result = 0;
		for (int i = 1; i < length; i++) {
			int left = 0;
			int right = i - 1;
			while (left <= right) {
				long product = 1L * arr[left] * arr[right];
				if (product == arr[i]) {
					dp[i] += dp[left] * dp[right];
					if (arr[left] != arr[right]) {
						dp[i] += dp[left] * dp[right];
					}
					left++;
					right--;
				} else if (product < arr[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		for (long num : dp) {
			result += num;
		}
		return (int) (result % 1000000007);
	}

}
