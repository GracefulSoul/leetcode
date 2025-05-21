package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class BuildArrayFromPermutation {

	// https://leetcode.com/problems/build-array-from-permutation/submissions/1640220633/
	public static void main(String[] args) {
		BuildArrayFromPermutation test = new BuildArrayFromPermutation();
		PrintUtil.print(test.buildArray(new int[] { 0, 2, 1, 5, 3, 4 }));
		PrintUtil.print(test.buildArray(new int[] { 5, 0, 1, 2, 3, 4 }));
	}

	public int[] buildArray(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = nums[nums[i]];
		}
		return result;
	}

}
