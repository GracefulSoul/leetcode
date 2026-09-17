package gracefulsoul.problems;

import java.util.Arrays;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {

	// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/submissions/2144789727/
	public static void main(String[] args) {
		FindTwoNonOverlappingSubArraysEachWithTargetSum test = new FindTwoNonOverlappingSubArraysEachWithTargetSum();
		System.out.println(test.minSumOfLengths(new int[] { 3, 2, 2, 4, 3 }, 3));
		System.out.println(test.minSumOfLengths(new int[] { 7, 3, 4, 7 }, 7));
		System.out.println(test.minSumOfLengths(new int[] { 4, 3, 2, 6, 2, 3, 4 }, 6));
	}

	public int minSumOfLengths(int[] arr, int target) {
		int length = arr.length;
		int result = length + 1;
		int[] dp = new int[length + 1];
		Arrays.fill(dp, length);
		for (int i = 0, j = 0, sum = 0; j < length; j++) {
			sum += arr[j];
			while (sum > target) {
				sum -= arr[i++];
			}
			dp[j + 1] = dp[j];
			if (sum == target) {
				result = Math.min(result, j - i + 1 + dp[i]);
				dp[j + 1] = Math.min(dp[j], j - i + 1);
			}
		}
		return result == length + 1 ? -1 : result;
	}

}
