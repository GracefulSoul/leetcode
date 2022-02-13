package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

	// https://leetcode.com/submissions/detail/639626434/
	public static void main(String[] args) {
		Solution2 solution = new Solution2(new int[] { 1, 2, 3 });
		print(solution.shuffle()); 	// Shuffle the array [1,2,3] and return its result.
									// Any permutation of [1,2,3] must be equally likely to be returned.
									// Example: return [3, 1, 2]
		print(solution.reset()); 	// Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
		print(solution.shuffle()); 	// Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
	}

	private static void print(int[] nums) {
		for (int idx = 0; idx < nums.length; idx++) {
			System.out.print(nums[idx]);
			if (idx < nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}

class Solution2 {

	private int[] nums;
	private int[] copy;
	private Random random;

	public Solution2(int[] nums) {
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