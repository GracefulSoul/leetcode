package gracefulsoul.object.solution.random.pick;

import java.util.Random;

public class Solution {

	private int[] nums;
	private Random random;

	public Solution(int[] nums) {
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