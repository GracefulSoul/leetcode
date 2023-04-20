package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SortArrayByParity {

	// https://leetcode.com/problems/sort-array-by-parity/submissions/936831244/
	public static void main(String[] args) {
		SortArrayByParity test = new SortArrayByParity();
		PrintUtil.print(test.sortArrayByParity(new int[] { 3, 1, 2, 4 }));
		PrintUtil.print(test.sortArrayByParity(new int[] { 0 }));
	}

	public int[] sortArrayByParity(int[] nums) {
		for (int i = 0, j = 0; j < nums.length; j++) {
			if (nums[j] % 2 == 0) {
				int temp = nums[i];
				nums[i++] = nums[j];
				nums[j] = temp;
			}
		}
		return nums;
	}

}
