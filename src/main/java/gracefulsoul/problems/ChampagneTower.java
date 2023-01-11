package gracefulsoul.problems;

public class ChampagneTower {

	// https://leetcode.com/problems/champagne-tower/submissions/876069144/
	public static void main(String[] args) {
		ChampagneTower test = new ChampagneTower();
		System.out.println(test.champagneTower(1, 1, 1));
		System.out.println(test.champagneTower(2, 1, 1));
		System.out.println(test.champagneTower(100000009, 33, 17));
	}

	public double champagneTower(int poured, int query_row, int query_glass) {
		double[] dp = new double[101];
		dp[0] = poured;
		for (int row = 1; row <= query_row; row++) {
			for (int col = row; col >= 0; col--) {
				double overflow = (dp[col] - 1) / 2.0;
				overflow = overflow <= 0 ? 0 : overflow;
				dp[col] = overflow;
				dp[col + 1] += overflow;
			}
		}
		return dp[query_glass] >= 1 ? 1 : dp[query_glass];
	}

}
