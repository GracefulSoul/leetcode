package gracefulsoul.problems;

import java.util.Arrays;

public class SudokuSolver {

	// https://leetcode.com/submissions/detail/495130327/
	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();
		test.solveSudoku(new char[][] {
			new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
			new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
			new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
			new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
			new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
			new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
			new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
			new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
			new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		});
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		this.solve(board);
		print(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (this.isValid(board, i, j, c)) {
							board[i][j] = c;
							if (this.solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c ||
				board[row][i] != '.' && board[row][i] == c ||
				(
					board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
					board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c
				)
			) {
				return false;
			}
		}
		return true;
	}

	private static void print(char[][] board) {
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}

}
