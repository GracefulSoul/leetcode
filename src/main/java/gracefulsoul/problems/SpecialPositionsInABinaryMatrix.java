package gracefulsoul.problems;

public class SpecialPositionsInABinaryMatrix {

	// https://leetcode.com/problems/special-positions-in-a-binary-matrix/submissions/1118861470/
	public static void main(String[] args) {
		SpecialPositionsInABinaryMatrix test = new SpecialPositionsInABinaryMatrix();
		System.out.println(test.numSpecial(new int[][] {
			{ 1, 0, 0 },
			{ 0, 0, 1 },
			{ 1, 0, 0 }
		}));
		System.out.println(test.numSpecial(new int[][] {
			{ 1, 0, 0 },
			{ 0, 1, 0 },
			{ 0, 0, 1 }
		}));
	}

	public int numSpecial(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[] rowSum = new int[row];
		int[] colSum = new int[col];
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1) {
					rowSum[i]++;
					colSum[j]++;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
					result++;
				}
			}
		}
		return result;
	}

}
