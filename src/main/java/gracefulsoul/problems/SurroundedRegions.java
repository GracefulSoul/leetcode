package gracefulsoul.problems;

public class SurroundedRegions {

	// https://leetcode.com/submissions/detail/540706564/
	public static void main(String[] args) {
		SurroundedRegions test = new SurroundedRegions();
		char[][] board1 = new char[][] {
			new char[] { 'X', 'X', 'X', 'X' },
			new char[] { 'X', 'O', 'O', 'X' },
			new char[] { 'X', 'X', 'O', 'X' },
			new char[] { 'X', 'O', 'X', 'X' }
		};
		test.solve(board1);
		print(board1);
		char[][] board2 = new char[][] {
			new char[] { 'X' }
		};
		test.solve(board2);
		print(board2);
	}

	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				this.dfs(i, 1, board);
			}
			if (board[i][board[0].length - 1] == 'O') {
				this.dfs(i, board[0].length - 2, board);
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				this.dfs(1, i, board);
			}
			if (board[board.length - 1][i] == 'O') {
				this.dfs(board.length - 2, i, board);
			}
		}
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == 'o') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(int i, int j, char[][] board) {
		if (i <= 0 || j <= 0 || i >= board.length - 1 || j >= board[0].length - 1 || board[i][j] == 'X' || board[i][j] == 'o') {
			return;
		}
		if (board[i][j] == 'O') {
			board[i][j] = 'o';
		}
		this.dfs(i + 1, j, board);
		this.dfs(i - 1, j, board);
		this.dfs(i, j + 1, board);
		this.dfs(i, j - 1, board);
	}

	private static void print(char[][] board) {
		for (char[] row : board) {
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
