package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ApplyOperationsToAnArray {

	// https://leetcode.com/problems/apply-operations-to-an-array/submissions/1558653840/
	public static void main(String[] args) {
		ApplyOperationsToAnArray test = new ApplyOperationsToAnArray();
		PrintUtil.print(test.applyOperations(new int[] { 1, 2, 2, 1, 1, 0 }));
		PrintUtil.print(test.applyOperations(new int[] { 0, 1 }));
	}

	public int[] applyOperations(int[] nums) {
		int length = nums.length;
		int index = 0;
		for (int i = 0; i < length; i++) {
			if (i < length - 1 && nums[i] == nums[i + 1]) {
				nums[i] *= 2;
				nums[i + 1] = 0;
			}
			if (nums[i] != 0) {
				if (i != index) {
					int temp = nums[i];
					nums[i] = nums[index];
					nums[index] = temp;
				}
				index++;
			}
		}
		return nums;
	}

}
