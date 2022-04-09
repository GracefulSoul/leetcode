package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ProductOfArrayExceptSelf {

	// https://leetcode.com/submissions/detail/586786954/
	public static void main(String[] args) {
		ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
		PrintUtil.print(test.productExceptSelf(new int[] { 1, 2, 3, 4 }));
		PrintUtil.print(test.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));
	}

	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		result[0] = 1;
		for (int idx = 1; idx < length; idx++) {
			result[idx] = result[idx - 1] * nums[idx - 1];
		}
		int right = 1;
		for (int idx = length - 1; idx >= 0; idx--) {
			result[idx] *= right;
			right *= nums[idx];
		}
		return result;
	}

}
