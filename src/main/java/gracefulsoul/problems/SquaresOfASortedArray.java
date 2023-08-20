package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SquaresOfASortedArray {

	// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1026245883/
	public static void main(String[] args) {
		SquaresOfASortedArray test = new SquaresOfASortedArray();
		PrintUtil.print(test.sortedSquares(new int[] { -4, -1, 0, 3, 10 }));
		PrintUtil.print(test.sortedSquares(new int[] { -7, -3, 2, 3, 11 }));
	}

	public int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		int i = 0;
		int j = length - 1;
		int k = length - 1;
		while (i <= j) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				result[k] = nums[i] * nums[i];
				i++;
			} else {
				result[k] = nums[j] * nums[j];
				j--;
			}
			k--;
		}
		return result;
	}

}
