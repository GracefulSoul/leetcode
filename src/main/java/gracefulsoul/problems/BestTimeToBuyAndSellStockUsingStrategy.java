package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockUsingStrategy {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/submissions/1858574268/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockUsingStrategy test = new BestTimeToBuyAndSellStockUsingStrategy();
		System.out.println(test.maxProfit(new int[] { 4, 2, 8 }, new int[] { -1, 0, 1 }, 2));
		System.out.println(test.maxProfit(new int[] { 5, 4, 3 }, new int[] { 1, 1, 0 }, 2));
	}

	public long maxProfit(int[] prices, int[] strategy, int k) {
		int length = prices.length;
		int h = k / 2;
		long[] sp = new long[length];
		long base = 0;
		for (int i = 0; i < length; i++) {
			sp[i] = (long) strategy[i] * prices[i];
			base += sp[i];
		}
		if (length == k) {
			long sumPrice = 0;
			for (int i = h; i < length; i++) {
				sumPrice += prices[i];
			}
			return base + Math.max(0, sumPrice - base);
		} else {
			long sumSp = 0;
			for (int i = 0; i < k; i++) {
				sumSp += sp[i];
			}
			long sumPrice = 0;
			for (int i = h; i < k; i++) {
				sumPrice += prices[i];
			}
			long max = sumPrice - sumSp;
			for (int i = 1; i <= length - k; i++) {
				sumSp += sp[i + k - 1] - sp[i - 1];
				sumPrice += prices[i + k - 1] - prices[i - 1 + h];
				max = Math.max(max, sumPrice - sumSp);
			}
			return base + Math.max(0, max);
		}
	}

}
