package gracefulsoul.problems;

public class AvailableCapturesForRook {

	// https://leetcode.com/problems/available-captures-for-rook/submissions/1066689028/
	public static void main(String[] args) {
		AvailableCapturesForRook test = new AvailableCapturesForRook();
		System.out.println(test.numRookCaptures(new char[][] {
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', 'p', '.', '.', '.', '.' },
			{ '.', '.', '.', 'R', '.', '.', '.', 'p' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', 'p', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }
		}));
		System.out.println(test.numRookCaptures(new char[][] {
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
			{ '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
			{ '.', 'p', 'B', 'R', 'B', 'p', '.', '.' },
			{ '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
			{ '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.'}
		}));
		System.out.println(test.numRookCaptures(new char[][] {
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', 'p', '.', '.', '.', '.' },
			{ '.', '.', '.', 'p', '.', '.', '.', '.' },
			{ 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', 'B', '.', '.', '.', '.' },
			{ '.', '.', '.', 'p', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }
		}));
	}

	private int[][] directions = new int[][] {
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 }
	};

	public int numRookCaptures(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'R') {
					return this.numRookCaptures(board, i, j, directions[0])
						 + this.numRookCaptures(board, i, j, directions[1])
						 + this.numRookCaptures(board, i, j, directions[2])
						 + this.numRookCaptures(board, i, j, directions[3]);
				}
			}
		}
		return 0;
	}

	private int numRookCaptures(char[][] board, int x, int y, int[] direction) {
		while (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] != 'B') {
			if (board[x][y] == 'p') {
				return 1;
			} else {
				x += direction[0];
				y += direction[1];
			}
		}
		return 0;
	}

}
