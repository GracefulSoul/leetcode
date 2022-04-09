package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MoveZeroes {

	// https://leetcode.com/submissions/detail/596640346/
	public static void main(String[] args) {
		MoveZeroes test = new MoveZeroes();
		int[] arr1 = new int[] { 0, 1, 0, 3, 12 };
		test.moveZeroes(arr1);
		PrintUtil.print(arr1);
		int[] arr2 = new int[] { 0 };
		test.moveZeroes(arr2);
		PrintUtil.print(arr2);
	}

	public void moveZeroes(int[] nums) {
		int idx = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[idx++] = num;
			}
		}
		while (idx < nums.length) {
			nums[idx++] = 0;
		}
	}

}
