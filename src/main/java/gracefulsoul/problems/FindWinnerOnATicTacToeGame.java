package gracefulsoul.problems;

public class FindWinnerOnATicTacToeGame {

	// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/submissions/1681368781/
	public static void main(String[] args) {
		FindWinnerOnATicTacToeGame test = new FindWinnerOnATicTacToeGame();
		System.out.println(test.tictactoe(new int[][] {
			{ 0, 0 },
			{ 2, 0 },
			{ 1, 1 },
			{ 2, 1 },
			{ 2, 2 }
		}));
		System.out.println(test.tictactoe(new int[][] {
			{ 0, 0 },
			{ 1, 1 },
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 0 },
			{ 2, 0 }
		}));
		System.out.println(test.tictactoe(new int[][] {
			{ 0, 0 },
			{ 1, 1 },
			{ 2, 0 },
			{ 1, 0 },
			{ 1, 2 },
			{ 2, 1 },
			{ 0, 1 },
			{ 0, 2 },
			{ 2, 2 }
		}));
	}

	public String tictactoe(int[][] moves) {
		int length = 3;
		int[] rows = new int[length];
		int[] cols = new int[length];
		int diagonal1 = 0;
		int diagonal2 = 0;
		int player = 1;
		for (int[] move : moves) {
			rows[move[0]] += player;
			cols[move[1]] += player;
			diagonal1 = move[0] == move[1] ? diagonal1 + player : diagonal1;
			diagonal2 = move[0] + move[1] == length - 1 ? diagonal2 + player : diagonal2;
			if (Math.abs(rows[move[0]]) == length
					|| Math.abs(cols[move[1]]) == length
					|| Math.abs(diagonal1) == length
					|| Math.abs(diagonal2) == length) {
				return player == 1 ? "A" : "B";
			}
			player *= -1;
		}
		return moves.length < 9 ? "Pending" : "Draw";
	}

}
