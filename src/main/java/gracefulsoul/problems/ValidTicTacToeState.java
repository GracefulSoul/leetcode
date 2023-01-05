package gracefulsoul.problems;

public class ValidTicTacToeState {

	// https://leetcode.com/problems/valid-tic-tac-toe-state/submissions/871893426/
	public static void main(String[] args) {
		ValidTicTacToeState test = new ValidTicTacToeState();
		System.out.println(test.validTicTacToe(new String[] { "O  ", "   ", "   " }));
		System.out.println(test.validTicTacToe(new String[] { "XOX", " X ", "   " }));
		System.out.println(test.validTicTacToe(new String[] { "XOX", "O O", "XOX" }));
	}

	public boolean validTicTacToe(String[] board) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'X') {
					count++;
				}
				if (board[i].charAt(j) == 'O') {
					count--;
				}
			}
		}
		if ((count != 0 && count != 1) || (this.isWin(board, 'X') && count == 0) || (this.isWin(board, 'O') && count == 1)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isWin(String[] board, char c) {
		return (board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c)
				|| (board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c)
				|| (board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c)
				|| (board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c)
				|| (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c)
				|| (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c)
				|| (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
				|| (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c);
	}

}
