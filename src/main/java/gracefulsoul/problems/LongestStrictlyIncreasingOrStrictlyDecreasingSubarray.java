package gracefulsoul.problems;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

	// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/submissions/1529596251/
	public static void main(String[] args) {
		LongestStrictlyIncreasingOrStrictlyDecreasingSubarray test = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();
		System.out.println(test.longestMonotonicSubarray(new int[] { 1, 4, 3, 3, 2 }));
		System.out.println(test.longestMonotonicSubarray(new int[] { 3, 3, 3, 3 }));
		System.out.println(test.longestMonotonicSubarray(new int[] { 3, 2, 1 }));
	}

	public int longestMonotonicSubarray(int[] nums) {
		int result = 1;
		int increase = 1;
		int decrease = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				increase++;
				decrease = 1;
			} else if (nums[i - 1] > nums[i]) {
				decrease++;
				increase = 1;
			} else {
				increase = 1;
				decrease = 1;
			}
			result = Math.max(result, Math.max(increase, decrease));
		}
		return result;
	}

}
