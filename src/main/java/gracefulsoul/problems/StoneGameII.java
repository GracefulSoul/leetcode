package gracefulsoul.problems;

public class StoneGameII {

	// https://leetcode.com/problems/stone-game-ii/submissions/957628567/
	public static void main(String[] args) {
		StoneGameII test = new StoneGameII();
		System.out.println(test.stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
		System.out.println(test.stoneGameII(new int[] { 1, 2, 3, 4, 5, 100 }));
	}

	public int stoneGameII(int[] piles) {
		int length = piles.length;
		for (int i = length - 2; i >= 0; i--) {
			piles[i] += piles[i + 1];
		}
		return this.dfs(piles, new int[length][length], 1, 0);
	}

	private int dfs(int[] piles, int[][] dp, int m, int p) {
		if (p + 2 * m >= piles.length) {
			return piles[p];
		} else if (dp[p][m] > 0) {
			return dp[p][m];
		} else {
			int result = 0;
			for (int i = 1; i <= 2 * m; i++) {
				result = Math.max(result, piles[p] - this.dfs(piles, dp, Math.max(i, m), p + i));
			}
			dp[p][m] = result;
			return result;
		}
	}

}
