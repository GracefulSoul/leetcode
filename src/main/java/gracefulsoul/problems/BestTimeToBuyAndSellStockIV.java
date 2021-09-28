package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockIV {

	// https://leetcode.com/submissions/detail/562177464/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIV test = new BestTimeToBuyAndSellStockIV();
		System.out.println(test.maxProfit(2, new int[] { 2, 4, 1 }));
		System.out.println(test.maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 }));
	}

	public int maxProfit(int k, int[] prices) {
		int length = prices.length;
		if (k >= length / 2) {
			return this.getMaxProfit(prices, length);
		} else {
			return this.getMaxProfitUsingDp(k, prices, length);
		}
	}

	private int getMaxProfit(int[] prices, int length) {
		int max = 0;
		for (int idx = 1; idx < length; idx++) {
			if (prices[idx] > prices[idx - 1]) {
				max += prices[idx] - prices[idx - 1];
			}
		}
		return max;
	}

	private int getMaxProfitUsingDp(int k, int[] prices, int length) {
		int[][] dp = new int[k + 1][length];
		for (int i = 1; i <= k; i++) {
			int max = dp[i - 1][0] - prices[0];
			for (int j = 1; j < length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
				max = Math.max(max, dp[i - 1][j] - prices[j]);
			}
		}
		return dp[k][length - 1];
	}

}
