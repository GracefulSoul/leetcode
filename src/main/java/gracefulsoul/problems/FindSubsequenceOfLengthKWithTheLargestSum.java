package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class FindSubsequenceOfLengthKWithTheLargestSum {

	// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/submissions/1678803522/
	public static void main(String[] args) {
		FindSubsequenceOfLengthKWithTheLargestSum test = new FindSubsequenceOfLengthKWithTheLargestSum();
		PrintUtil.print(test.maxSubsequence(new int[] { 2, 1, 3, 3 }, 2));
		PrintUtil.print(test.maxSubsequence(new int[] { -1, -2, 3, 4 }, 3));
		PrintUtil.print(test.maxSubsequence(new int[] { 3, 4, 3, 3 }, 2));
	}

	public int[] maxSubsequence(int[] nums, int k) {
		int length = nums.length;
		int[] sorted = Arrays.copyOf(nums, length);
		Arrays.sort(sorted);
		int limit = sorted[length - k];
		int count = 0;
		for (int i = length - k; i < length; i++) {
			if (sorted[i] == limit) {
				count++;
			}
		}
		int[] result = new int[k];
		int i = 0;
		for (int num : nums) {
			if (num > limit) {
				result[i++] = num;
			} else if (num == limit && count > 0) {
				result[i++] = num;
				count--;
			}
			if (i == k) {
				break;
			}
		}
		return result;
	}

}
