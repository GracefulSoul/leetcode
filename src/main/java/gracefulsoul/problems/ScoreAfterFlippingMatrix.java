package gracefulsoul.problems;

public class ScoreAfterFlippingMatrix {

	// https://leetcode.com/problems/score-after-flipping-matrix/submissions/908592902/
	public static void main(String[] args) {
		ScoreAfterFlippingMatrix test = new ScoreAfterFlippingMatrix();
		System.out.println(test.matrixScore(new int[][] {
			{ 0, 0, 1, 1 },
			{ 1, 0, 1, 0 },
			{ 1, 1, 0, 0 }
		}));
		System.out.println(test.matrixScore(new int[][] {
			{ 0 }
		}));
	}

	public int matrixScore(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = (1 << (col - 1)) * row;
		for (int j = 1; j < col; j++) {
			int same = 0;
			for (int i = 0; i < row; i++) {
				if (grid[i][j] == grid[i][0]) {
					same++;
				}
			}
			result += Math.max(same, row - same) * (1 << (col - 1 - j));
		}
		return result;
	}

}
