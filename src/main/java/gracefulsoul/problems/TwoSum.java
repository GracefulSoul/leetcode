package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class TwoSum {

	// https://leetcode.com/submissions/detail/477242867/
	public static void main(String[] args) {
		TwoSum test = new TwoSum();
		PrintUtil.print(test.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		PrintUtil.print(test.twoSum(new int[] { 3, 2, 4 }, 6));
		PrintUtil.print(test.twoSum(new int[] { 3, 3 }, 6));

	}

	public int[] twoSum(int[] nums, int target) {
		for (int idx1 = 0; idx1 < nums.length - 1; idx1++) {
			for (int idx2 = idx1 + 1; idx2 < nums.length; idx2++) {
				if (target == nums[idx1] + nums[idx2]) {
					return new int[] { idx1, idx2 };
				}
			}
		}
		return new int[2];
	}

}
