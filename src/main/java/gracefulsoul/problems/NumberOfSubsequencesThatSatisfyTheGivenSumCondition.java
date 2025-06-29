package gracefulsoul.problems;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

	// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/submissions/1679787095/
	public static void main(String[] args) {
		NumberOfSubsequencesThatSatisfyTheGivenSumCondition test = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
		System.out.println(test.numSubseq(new int[] { 3, 5, 6, 7 }, 9));
		System.out.println(test.numSubseq(new int[] { 3, 3, 6, 8 }, 10));
		System.out.println(test.numSubseq(new int[] { 2, 3, 3, 4, 6, 7 }, 12));
	}

	private static final int MOD = 1000000007;

	public int numSubseq(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
		int length = nums.length;
		int[] pows = new int[length];
		pows[0] = 1;
		for (int i = 1; i < length; i++) {
			pows[i] = (2 * pows[i - 1]) % MOD;
		}
		int left = 0;
		int right = length - 1;
		while (left <= right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				result = (result + pows[right - left++]) % MOD;
			}
		}
		return result;
	}

}
