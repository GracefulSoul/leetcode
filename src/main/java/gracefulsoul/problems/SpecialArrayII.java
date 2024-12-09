package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SpecialArrayII {

	// https://leetcode.com/problems/special-array-ii/submissions/1474195828/
	public static void main(String[] args) {
		SpecialArrayII test = new SpecialArrayII();
		PrintUtil.print(test.isArraySpecial(new int[] { 3, 4, 1, 2, 6 }, new int[][] {
			{ 0, 4 }
		}));
		PrintUtil.print(test.isArraySpecial(new int[] { 4, 3, 1, 6 }, new int[][] {
			{ 0, 2 },
			{ 2, 3 }
		}));
	}

	public boolean[] isArraySpecial(int[] nums, int[][] queries) {
		boolean[] result = new boolean[queries.length];
		int[] counts = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			counts[i] = counts[i - 1];
			if (nums[i - 1] % 2 == nums[i] % 2) {
				counts[i]++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			result[i] = counts[query[1]] - counts[query[0]] == 0;
		}
		return result;
	}

}
