package gracefulsoul.problems;

public class MaximumProductOfThreeNumbers {

	// https://leetcode.com/submissions/detail/776820502/
	public static void main(String[] args) {
		MaximumProductOfThreeNumbers test = new MaximumProductOfThreeNumbers();
		System.out.println(test.maximumProduct(new int[] { 1, 2, 3 }));
		System.out.println(test.maximumProduct(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.maximumProduct(new int[] { -1, -2, -3 }));
	}

	public int maximumProduct(int[] nums) {
		if (nums.length == 3) {
			return nums[0] * nums[1] * nums[2];
		}
		int[] max = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
		int[] min = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] < min[1]) {
				if (nums[idx] < min[0]) {
					min[1] = min[0];
					min[0] = nums[idx];
				} else {
					min[1] = nums[idx];
				}
			}
			if (nums[idx] > max[0]) {
				if (nums[idx] > max[2]) {
					max[0] = max[1];
					max[1] = max[2];
					max[2] = nums[idx];
				} else if (nums[idx] > max[1]) {
					max[0] = max[1];
					max[1] = nums[idx];
				} else {
					max[0] = nums[idx];
				}
			}
		}
		return Math.max(max[2] * max[1] * max[0], max[2] * min[0] * min[1]);
	}

}
