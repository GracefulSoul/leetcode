package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindXValueOfArrayI {

	// https://leetcode.com/problems/find-x-value-of-array-i/submissions/2148562798/
	public static void main(String[] args) {
		FindXValueOfArrayI test = new FindXValueOfArrayI();
		PrintUtil.print(test.resultArray(new int[] { 1, 2, 3, 4, 5 }, 3));
		PrintUtil.print(test.resultArray(new int[] { 1, 2, 4, 8, 16, 32 }, 4));
		PrintUtil.print(test.resultArray(new int[] { 1, 1, 2, 1, 1 }, 2));
	}

	public long[] resultArray(int[] nums, int k) {
		long[] result = new long[k];
		int[] counts = new int[k];
		for (int num : nums) {
			num %= k;
			int[] curr = new int[k];
			curr[num] = 1;
			for (int i = 0; i < k; i++) {
				curr[(i * num) % k] += counts[i];
			}
			counts = curr;
			for (int i = 0; i < k; i++) {
				result[i] += counts[i];
			}
		}
		return result;
	}

}
