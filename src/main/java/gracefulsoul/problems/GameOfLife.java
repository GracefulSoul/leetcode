package gracefulsoul.problems;

public class GameOfLife {

	// https://leetcode.com/submissions/detail/598303826/
	public static void main(String[] args) {
		GameOfLife test = new GameOfLife();
		int[][] board1 = new int[][] {
			new int[] { 0, 1, 0 },
			new int[] { 0, 0, 1 },
			new int[] { 1, 1, 1 },
			new int[] { 0, 0, 0 }
		};
		test.gameOfLife(board1);
		print(board1);
		int[][] board2 = new int[][] {
			new int[] { 1, 1 },
			new int[] { 1, 0 }
		};
		test.gameOfLife(board2);
		print(board2);
	}

	public void gameOfLife(int[][] board) {
		int rowSize = board.length;
		int colSize = board[0].length;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				int lives = this.getLiveNeighbors(board, rowSize, colSize, i, j);
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	private int getLiveNeighbors(int[][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}

	private static void print(int[][] board) {
		for (int[] row : board) {
			for (int idx = 0; idx < row.length; idx++) {
				System.out.print(row[idx]);
				if (idx < row.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

}
