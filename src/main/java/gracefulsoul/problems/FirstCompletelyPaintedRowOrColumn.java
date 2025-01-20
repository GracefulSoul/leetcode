package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {

	// https://leetcode.com/problems/first-completely-painted-row-or-column/submissions/1514085577/
	public static void main(String[] args) {
		FirstCompletelyPaintedRowOrColumn test = new FirstCompletelyPaintedRowOrColumn();
		System.out.println(test.firstCompleteIndex(new int[] { 1, 3, 4, 2 }, new int[][] {
			{ 1, 4 },
			{ 2, 3 }
		}));
		System.out.println(test.firstCompleteIndex(new int[] { 2, 8, 7, 4, 1, 3, 5, 6, 9 }, new int[][] {
			{ 3, 2, 5 },
			{ 1, 4, 6 },
			{ 8, 7, 9 }
		}));
	}

	public int firstCompleteIndex(int[] arr, int[][] mat) {
		Map<Integer, int[]> map = new HashMap<>();
		int row = mat.length;
		int col = mat[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map.put(mat[i][j], new int[] { i, j });
			}
		}
		int[] a = new int[row];
		int[] b = new int[col];
		for (int i = 0; i < arr.length; i++) {
			int[] c = map.get(arr[i]);
			a[c[0]]++;
			b[c[1]]++;
			if (a[c[0]] == col || b[c[1]] == row) {
				return i;
			}
		}
		return -1;
	}

}
