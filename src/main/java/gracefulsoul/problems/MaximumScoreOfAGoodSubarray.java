package gracefulsoul.problems;

public class MaximumScoreOfAGoodSubarray {

	// https://leetcode.com/problems/maximum-score-of-a-good-subarray/submissions/1081040870/
	public static void main(String[] args) {
		MaximumScoreOfAGoodSubarray test = new MaximumScoreOfAGoodSubarray();
		System.out.println(test.maximumScore(new int[] { 1, 4, 3, 7, 4, 5 }, 3));
		System.out.println(test.maximumScore(new int[] { 5, 5, 4, 5, 4, 1, 1, 1 }, 0));
	}

	public int maximumScore(int[] nums, int k) {
		int result = nums[k];
		int min = nums[k];
		int length = nums.length;
		for (int i = k, j = k; i > 0 || j < length - 1;) {
			if (i == 0) {
				j++;
			} else if (j == length - 1) {
				i--;
			} else if (nums[i - 1] < nums[j + 1]) {
				j++;
			} else {
				i--;
			}
			min = Math.min(min, Math.min(nums[i], nums[j]));
			result = Math.max(result, min * (j - i + 1));
		}
		return result;
	}

}
