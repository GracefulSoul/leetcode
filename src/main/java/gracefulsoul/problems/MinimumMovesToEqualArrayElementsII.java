package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

	// https://leetcode.com/submissions/detail/684494857/
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElementsII test = new MinimumMovesToEqualArrayElementsII();
		System.out.println(test.minMoves2(new int[] { 1, 2, 3 }));
		System.out.println(test.minMoves2(new int[] { 1, 10, 2, 9 }));
	}

	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int move = 0;
		while (left < right) {
			move += nums[right--] - nums[left++];
		}
		return move;
	}

}
