package gracefulsoul.problems;

import java.util.Random;

public class RandomPickIndex {

	// https://leetcode.com/submissions/detail/649035501/
	public static void main(String[] args) {
		Solution1 solution = new Solution1(new int[] { 1, 2, 3, 3, 3 });
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
		System.out.println(solution.pick(1)); // It should return 0. Since in the array only nums[0] is equal to 1.
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
	}

}

class Solution1 {

	private int[] nums;
	private Random random;

	public Solution1(int[] nums) {
		this.nums = nums;
		this.random = new Random();
	}

	public int pick(int target) {
		int index = -1;
		int max = 1;
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] == target && random.nextInt(max++) == 0) {
				index = idx;
			}
		}
		return index;
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */