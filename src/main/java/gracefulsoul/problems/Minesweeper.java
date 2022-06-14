package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class Minesweeper {

	// https://leetcode.com/submissions/detail/722002583/
	public static void main(String[] args) {
		Minesweeper test = new Minesweeper();
		PrintUtil.print(test.updateBoard(new char[][] {
			{ 'E', 'E', 'E', 'E', 'E' },
			{ 'E', 'E', 'M', 'E', 'E' },
			{ 'E', 'E', 'E', 'E', 'E' },
			{ 'E', 'E', 'E', 'E', 'E' }
		}, new int[] { 3, 0 }));
		PrintUtil.print(test.updateBoard(new char[][] {
			{ 'B', '1', 'E', '1', 'B' },
			{ 'B', '1', 'M', '1', 'B' },
			{ 'B', '1', '1', '1', 'B' },
			{ 'B', 'B', 'B', 'B', 'B' }
		}, new int[] { 1, 2 }));
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];
		if (board[x][y] == 'M') {
			board[x][y] = 'X';
		} else {
			this.dfs(board, x, y, board.length, board[0].length);
		}
		return board;
	}

	private void dfs(char[][] board, int x, int y, int rowLength, int colLength) {
		if (x < 0 || y < 0 || x >= rowLength || y >= colLength || board[x][y] != 'E') {
			return;
		}
		int num = this.findMines(board, x, y, rowLength, colLength);
		if (num == 0) {
			board[x][y] = 'B';
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					this.dfs(board, x + i, y + j, rowLength, colLength);
				}
			}
		} else {
			board[x][y] = (char) ('0' + num);
		}
	}

	private int findMines(char[][] board, int x, int y, int rowLength, int colLength) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int x1 = x + i;
				int y1 = y + j;
				if (x1 >= 0 && y1 >= 0 && x1 < rowLength && y1 < colLength && board[x1][y1] == 'M') {
					count++;
				}
			}
		}
		return count;
	}

}
