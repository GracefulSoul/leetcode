package gracefulsoul.problems;

public class ValidTicTacToeState {

	// https://leetcode.com/problems/valid-tic-tac-toe-state/submissions/871893426/
	public static void main(String[] args) {
		ValidTicTacToeState test = new ValidTicTacToeState();
		System.out.println(test.validTicTacToe(new String[] { "O  ", "   ", "   " }));
		System.out.println(test.validTicTacToe(new String[] { "XOX", " X ", "   " }));
		System.out.println(test.validTicTacToe(new String[] { "XOX", "O O", "XOX" }));
		System.out.println(test.validTicTacToe(new String[] { "XXX", "   ", "OOO" }));
	}

	public boolean validTicTacToe(String[] board) {
		int diff = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'X') {
					diff++;
				}
				if (board[i].charAt(j) == 'O') {
					diff--;
				}
			}
		}
		return !((diff != 0 && diff != 1) || (this.isWin(board, 'X') && diff == 0) || (this.isWin(board, 'O') && diff == 1));
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
