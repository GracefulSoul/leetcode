package gracefulsoul.problems;

public class MaximumSubarray {

	// https://leetcode.com/submissions/detail/501772060/
	public static void main(String[] args) {
		MaximumSubarray test = new MaximumSubarray();
		System.out.println(test.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		test.maxSubArray(new int[] { 1 });
		test.maxSubArray(new int[] { 5, 4, -1, 7, 8 });
	}

	public int maxSubArray(int[] nums) {
		int subSum = nums[0];
		int result = subSum;
		for (int idx = 1; idx < nums.length; idx++) {
			subSum = Math.max(subSum + nums[idx], nums[idx]);
			result = Math.max(result, subSum);
		}
		return result;
	}

}
