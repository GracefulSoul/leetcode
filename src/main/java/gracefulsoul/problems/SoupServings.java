package gracefulsoul.problems;

public class SoupServings {

	// https://leetcode.com/problems/soup-servings/submissions/879836198/
	public static void main(String[] args) {
		SoupServings test = new SoupServings();
		System.out.println(test.soupServings(50));
		System.out.println(test.soupServings(100));
	}

	public double soupServings(int n) {
		n = (n + 24) / 25;
		return n > 192 ? 1.0 : this.dfs(new double[n + 1][n + 1], n, n);
	}

	private double dfs(double[][] dp, int a, int b) {
		if (a <= 0 && b <= 0) {
			return 0.5;
		} else if (a <= 0) {
			return 1;
		} else if (b <= 0) {
			return 0;
		} else if (dp[a][b] > 0) {
			return dp[a][b];
		} else {
			return dp[a][b] = 0.25 * (this.dfs(dp, a - 4, b) + this.dfs(dp, a - 3, b - 1) + this.dfs(dp, a - 2, b - 2) + this.dfs(dp, a - 1, b - 3));
		}
	}

}
