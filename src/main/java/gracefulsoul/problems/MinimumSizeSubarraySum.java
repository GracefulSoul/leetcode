package gracefulsoul.problems;

public class MinimumSizeSubarraySum {

	// https://leetcode.com/submissions/detail/570826483/
	public static void main(String[] args) {
		MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		System.out.println(test.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(test.minSubArrayLen(4, new int[] { 1, 4, 4 }));
		System.out.println(test.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	public int minSubArrayLen(int target, int[] nums) {
		int length = nums.length;
		int result = length + 1;
		int index = 0;
		for (int i = 0; i < length; i++) {
			target -= nums[i];
			while (target <= 0) {
				result = Math.min(result, i - index + 1);
				target += nums[index++];
			}
		}
		return result % (length + 1);
	}

}
