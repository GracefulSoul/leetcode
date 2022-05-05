package gracefulsoul.object.solution.shuffle.array;

import java.util.Arrays;
import java.util.Random;

public class Solution {

	private int[] nums;
	private int[] copy;
	private Random random;

	public Solution(int[] nums) {
		this.nums = nums;
		this.copy = Arrays.copyOf(nums, nums.length);
		this.random = new Random();
	}

	public int[] reset() {
		this.copy = Arrays.copyOf(this.nums, this.nums.length);
		return this.copy;
	}

	public int[] shuffle() {
		for (int idx = this.copy.length - 1; idx >= 0; idx--) {
			int num = this.random.nextInt(idx + 1);
			int temp = this.copy[num];
			this.copy[num] = this.copy[idx];
			this.copy[idx] = temp;
		}
		return this.copy;
	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */