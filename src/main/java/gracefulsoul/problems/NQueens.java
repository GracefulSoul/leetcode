package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		NQueens test = new NQueens();
		System.out.println(test.solveNQueens(4));
		System.out.println(test.solveNQueens(1));
	}

	// https://leetcode.com/problems/n-queens/submissions/1614623321/
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}
		List<List<String>> result = new ArrayList<>();
		this.dfs(n, board, result, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
		return result;
	}

	private void dfs(int n, char[][] board, List<List<String>> result, int i, boolean[] cols, boolean[] diagonals1, boolean[] diagonals2) {
		if (i == n) {
			List<String> list = new ArrayList<>();
			for (char[] row : board) {
				list.add(new String(row));
			}
			result.add(list);
		} else {
			for (int j = 0; j < cols.length; j++) {
				if (!cols[j] && !diagonals1[i + j] && !diagonals2[j - i + n - 1]) {
					board[i][j] = 'Q';
					cols[j] = diagonals1[i + j] = diagonals2[j - i + n - 1] = true;
					this.dfs(n, board, result, i + 1, cols, diagonals1, diagonals2);
					cols[j] = diagonals1[i + j] = diagonals2[j - i + n - 1] = false;
					board[i][j] = '.';
				}
			}
		}
	}

}
