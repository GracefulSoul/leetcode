package gracefulsoul.problems;

public class ProfitableSchemes {

	// https://leetcode.com/problems/profitable-schemes/submissions/919401660/
	public static void main(String[] args) {
		ProfitableSchemes test = new ProfitableSchemes();
		System.out.println(test.profitableSchemes(5, 3, new int[] { 2, 2 }, new int[] { 2, 3 }));
		System.out.println(test.profitableSchemes(10, 5, new int[] { 2, 3, 5 }, new int[] { 6, 7, 8 }));
	}

	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		int[][] dp = new int[n + 1][minProfit + 1];
		dp[0][0] = 1;
		int mod = 1000000007;
		for (int k = 0; k < group.length; k++) {
			int g = group[k];
			int p = profit[k];
			for (int i = n; g <= i; i--) {
				for (int j = minProfit; 0 <= j; j--) {
					dp[i][j] = (dp[i][j] + dp[i - g][Math.max(0, j - p)]) % mod;
				}
			}
		}
		int result = 0;
		for (int i = 0; i <= n; i++) {
			result = (result + dp[i][minProfit]) % mod;
		}
		return result;
	}

}
