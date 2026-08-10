package gracefulsoul.problems;

public class StoneGameIV {

	// https://leetcode.com/problems/stone-game-iv/submissions/2101383774/
	public static void main(String[] args) {
		StoneGameIV test = new StoneGameIV();
		System.out.println(test.winnerSquareGame(1));
		System.out.println(test.winnerSquareGame(2));
		System.out.println(test.winnerSquareGame(4));
	}

	public boolean winnerSquareGame(int n) {
		boolean dp[] = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; (j * j) <= i; j++) {
				if (!dp[i - (j * j)]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

}
