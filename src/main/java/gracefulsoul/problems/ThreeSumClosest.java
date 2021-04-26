package gracefulsoul.problems;

import java.util.Arrays;

public class ThreeSumClosest {

	// https://leetcode.com/submissions/detail/485417150/
	public static void main(String[] args) {
		ThreeSumClosest test = new ThreeSumClosest();
		System.out.println(test.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		for (int idx = 0; idx < nums.length - 2; idx++) {
			int start = idx + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[idx] + nums[start] + nums[end];
				if (Math.abs(target - result) > Math.abs(target - sum)) {
					result = sum;
				}
				if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}
		return result;
	}

}
