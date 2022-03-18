package gracefulsoul.problems;

public class BattleshipsInABoard {

	// https://leetcode.com/submissions/detail/662239142/
	public static void main(String[] args) {
		BattleshipsInABoard test = new BattleshipsInABoard();
		System.out.println(test.countBattleships(new char[][] {
			{ 'X', '.', '.', 'X' },
			{ '.', '.', '.', 'X' },
			{ '.', '.', '.', 'X' }
		}));
		System.out.println(test.countBattleships(new char[][] {
			{ '.' }
		}));
	}

	public int countBattleships(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '.' || (i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
					continue;
				}
				count++;
			}
		}
		return count;
	}

}
