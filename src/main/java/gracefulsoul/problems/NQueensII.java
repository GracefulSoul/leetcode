package gracefulsoul.problems;

public class NQueensII {

	// https://leetcode.com/problems/n-queens-ii/submissions/1621007254/
	public static void main(String[] args) {
		NQueensII test = new NQueensII();
		System.out.println(test.totalNQueens(4));
		System.out.println(test.totalNQueens(1));
	}

	private int count;

	public int totalNQueens(int n) {
		this.count = 0;
		int diagonalLength = 2 * n;
		this.backtracking(n, 0, new boolean[n], new boolean[diagonalLength], new boolean[diagonalLength]);
		return this.count;
	}

	private void backtracking(int n, int i, boolean[] values, boolean[] diagonal1, boolean[] diagonal2) {
		if (i == n) {
			this.count++;
		} else {
			for (int j = 0; j < n; j++) {
				int index1 = j - i + n;
				int index2 = j + i;
				if (!values[j] && !diagonal1[index1] && !diagonal2[index2]) {
					values[j] = diagonal1[index1] = diagonal2[index2] = true;
					this.backtracking(n, i + 1, values, diagonal1, diagonal2);
					values[j] = diagonal1[index1] = diagonal2[index2] = false;
				}
			}
		}
	}

}
