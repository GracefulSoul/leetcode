package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindThePrefixCommonArrayOfTwoArrays {

	// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/submissions/1508202594/
	public static void main(String[] args) {
		FindThePrefixCommonArrayOfTwoArrays test = new FindThePrefixCommonArrayOfTwoArrays();
		PrintUtil.print(test.findThePrefixCommonArray(new int[] { 1, 3, 2, 4 }, new int[] { 3, 1, 2, 4 }));
		PrintUtil.print(test.findThePrefixCommonArray(new int[] { 2, 3, 1 }, new int[] { 3, 1, 2 }));
	}

	public int[] findThePrefixCommonArray(int[] A, int[] B) {
		int length = A.length;
		int[] counts = new int[length + 1];
		int[] result = new int[length];
		int common = 0;
		for (int i = 0; i < length; i++) {
			if (++counts[A[i]] == 2) {
				common++;
			}
			if (++counts[B[i]] == 2) {
				common++;
			}
			result[i] = common;
		}
		return result;
	}

}
