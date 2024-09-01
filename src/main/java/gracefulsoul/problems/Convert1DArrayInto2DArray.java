package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class Convert1DArrayInto2DArray {

	// https://leetcode.com/problems/convert-1d-array-into-2d-array/submissions/1374736202/
	public static void main(String[] args) {
		Convert1DArrayInto2DArray test = new Convert1DArrayInto2DArray();
		PrintUtil.print(test.construct2DArray(new int[] { 1, 2, 3, 4 }, 2, 2));
		PrintUtil.print(test.construct2DArray(new int[] { 1, 2, 3 }, 1, 3));
		PrintUtil.print(test.construct2DArray(new int[] { 1, 2 }, 1, 1));
	}

	public int[][] construct2DArray(int[] original, int m, int n) {
		if (original.length == m * n) {
			int[][] result = new int[m][n];
			for (int i = 0; i < original.length; i++) {
				result[i / n][i % n] = original[i];
			}
			return result;
		} else {
			return new int[0][0];
		}
	}

}
