package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {

	// https://leetcode.com/problems/lucky-numbers-in-a-matrix/submissions/1326095011/
	public static void main(String[] args) {
		LuckyNumbersInAMatrix test = new LuckyNumbersInAMatrix();
		System.out.println(test.luckyNumbers(new int[][] {
			{ 3, 7, 8 },
			{ 9, 11, 13 },
			{ 15, 16, 17 }
		}));
		System.out.println(test.luckyNumbers(new int[][] {
			{ 1, 10, 4, 2 },
			{ 9, 3, 8, 7 },
			{ 15, 16, 17, 12 }
		}));
		System.out.println(test.luckyNumbers(new int[][] {
			{ 7, 8 },
			{ 1, 2 }
		}));
	}

	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int index = this.getIndexOfMinValue(matrix[i]);
			int value = matrix[i][index];
			if (this.checkMaxValue(matrix, index, value)) {
				result.add(value);
			}
		}
		return result;
	}

	private int getIndexOfMinValue(int[] row) {
		int index = 0;
		for (int i = 1, min = row[index]; i < row.length; i++) {
			if (row[i] < min) {
				min = row[i];
				index = i;
			}
		}
		return index;
	}

	private boolean checkMaxValue(int[][] matrix, int i, int value) {
		for (int[] row : matrix) {
			if (row[i] > value) {
				return false;
			}
		}
		return true;
	}

}
