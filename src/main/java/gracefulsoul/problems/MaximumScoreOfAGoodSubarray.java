package gracefulsoul.problems;

public class MaximumScoreOfAGoodSubarray {

	// https://leetcode.com/problems/maximum-score-of-a-good-subarray/submissions/1081095937/
	public static void main(String[] args) {
		MaximumScoreOfAGoodSubarray test = new MaximumScoreOfAGoodSubarray();
		System.out.println(test.maximumScore(new int[] { 1, 4, 3, 7, 4, 5 }, 3));
		System.out.println(test.maximumScore(new int[] { 5, 5, 4, 5, 4, 1, 1, 1 }, 0));
	}

	public int maximumScore(int[] nums, int k) {
		int length = nums.length;
		int i = k - 1;
		int j = k + 1;
		int min = nums[k];
		while (0 <= i && min <= nums[i]) {
			i--;
		}
		while (j < length && min <= nums[j]) {
			j++;
		}
		int result = min * (j - i - 1);
		while (0 <= i || j < length) {
			if (i < 0 || (j < length && nums[i] <= nums[j])) {
				min = nums[j];
				while (j < length && min <= nums[j]) {
					j++;
				}
			} else {
				min = nums[i];
				while (0 <= i && min <= nums[i]) {
					i--;
				}
			}
			result = Math.max(result, min * (j - i - 1));
		}
		return result;
	}

}
