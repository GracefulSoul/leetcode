package gracefulsoul.problems;

public class LongestContinuousIncreasingSubsequence {

	// https://leetcode.com/submissions/detail/809708790/
	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence test = new LongestContinuousIncreasingSubsequence();
		System.out.println(test.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
		System.out.println(test.findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
	}

	public int findLengthOfLCIS(int[] nums) {
		int result = 0;
		int count = 1;
		for (int idx = 1; idx < nums.length; idx++) {
			if (nums[idx - 1] < nums[idx]) {
				count++;
			} else {
				result = Math.max(result, count);
				count = 1;
			}
		}
		return Math.max(result, count);
	}

}
