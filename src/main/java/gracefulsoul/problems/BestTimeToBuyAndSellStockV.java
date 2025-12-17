package gracefulsoul.problems;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockV {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/submissions/1857616494/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockV test = new BestTimeToBuyAndSellStockV();
		System.out.println(test.maximumProfit(new int[] { 1, 7, 9, 8, 2 }, 2));
		System.out.println(test.maximumProfit(new int[] { 12, 16, 19, 19, 8, 1, 19, 13, 9 }, 3));
	}

	public long maximumProfit(int[] prices, int k) {
		long[] dp = new long[k + 1];
		long[] bought = new long[k];
		long[] sold = new long[k];
		Arrays.fill(bought, -1000000000);
		for (int price : prices) {
			for (int i = k; 1 <= i; i--) {
				dp[i] = Math.max(dp[i], Math.max(bought[i - 1] + price, sold[i - 1] - price));
				bought[i - 1] = Math.max(bought[i - 1], dp[i - 1] - price);
				sold[i - 1] = Math.max(sold[i - 1], dp[i - 1] + price);
			}
		}
		long result = 0;
		for (long value : dp) {
			result = Math.max(result, value);
		}
		return result;
	}

}
