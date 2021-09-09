package gracefulsoul.problems;

public class MaximumProductSubarray {

	// https://leetcode.com/submissions/detail/551796642/
	public static void main(String[] args) {
		MaximumProductSubarray test = new MaximumProductSubarray();
		System.out.println(test.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(test.maxProduct(new int[] { -2, 0, -1 }));
	}

	public int maxProduct(int[] nums) {
		int max = nums[0];
		int length = nums.length;
		int left = 1;
		int right = 1;
		for (int idx = 0; idx < length; idx++) {
			left = (left == 0 ? 1 : left) * nums[idx];
			right = (right == 0 ? 1 : right) * nums[length - 1 - idx];
			max = Math.max(max, Math.max(left, right));
		}
		return max;
	}

}
