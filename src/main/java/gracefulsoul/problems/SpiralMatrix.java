package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	// https://leetcode.com/submissions/detail/502357804/
	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix();
		System.out.println(test.spiralOrder(new int[][] {
			new int[] { 1, 2, 3 },
			new int[] { 4, 5, 6 },
			new int[] { 7, 8, 9 }
		}));
		System.out.println(test.spiralOrder(new int[][] {
			new int[] { 1, 2, 3, 4 },
			new int[] { 5, 6, 7, 8 },
			new int[] { 9, 10, 11, 12 }
		}));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int row = 0;
		int col = 0;
		int rowMax = rowSize - 1;
		int colMax = colSize - 1;
		while (result.size() < rowSize * colSize) {
			for (int idx = col; idx <= colMax && result.size() < rowSize * colSize; idx++) {
				result.add(matrix[row][idx]);
			}
			for (int idx = row + 1; idx <= rowMax - 1 && result.size() < rowSize * colSize; idx++) {
				result.add(matrix[idx][colMax]);
			}
			for (int idx = colMax; idx >= col && result.size() < rowSize * colSize; idx--) {
				result.add(matrix[rowMax][idx]);
			}
			for (int idx = rowMax - 1; idx >= row + 1 && result.size() < rowSize * colSize; idx--) {
				result.add(matrix[idx][col]);
			}
			row++;
			col++;
			rowMax--;
			colMax--;
		}
		return result;
	}

}
