package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FinalArrayStateAfterKMultiplicationOperationsI {

	// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/submissions/1480075501/
	public static void main(String[] args) {
		FinalArrayStateAfterKMultiplicationOperationsI test = new FinalArrayStateAfterKMultiplicationOperationsI();
		PrintUtil.print(test.getFinalState(new int[] { 2, 1, 3, 5, 6 }, 5, 2));
		PrintUtil.print(test.getFinalState(new int[] { 1, 2 }, 3, 4));
	}

	public int[] getFinalState(int[] nums, int k, int multiplier) {
		while (k > 0) {
			int index = 0;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < nums[index]) {
					index = i;
				}
			}
			nums[index] = nums[index] * multiplier;
			k--;
		}
		return nums;
	}

}
