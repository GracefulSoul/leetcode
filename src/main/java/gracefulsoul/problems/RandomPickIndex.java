package gracefulsoul.problems;

import java.util.Random;

public class RandomPickIndex {

	// https://leetcode.com/submissions/detail/648982402/
	public static void main(String[] args) {
		Solution1 solution = new Solution1(new int[] { 1, 2, 3, 3, 3 });
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
		System.out.println(solution.pick(1)); // It should return 0. Since in the array only nums[0] is equal to 1.
		System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
	}

}

class Solution1 {

	int[] nums;
	Random random;

	public Solution1(int[] nums) {
		this.nums = nums;
		this.random = new Random();
	}

	public int pick(int target) {
		int result = -1;
		int range = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == target && random.nextInt(++range) == 0) {
				result = i;
			}
		return result;
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */