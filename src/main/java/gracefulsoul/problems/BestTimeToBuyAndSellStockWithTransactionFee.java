package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockWithTransactionFee {

	// https://leetcode.com/submissions/detail/836420002/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithTransactionFee test = new BestTimeToBuyAndSellStockWithTransactionFee();
		System.out.println(test.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
		System.out.println(test.maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3));
	}

	public int maxProfit(int[] prices, int fee) {
		int profit = 0;
		int hold = -prices[0];
		for (int price : prices) {
			profit = Math.max(profit, hold + price - fee);
			hold = Math.max(hold, profit - price);
		}
		return profit;
	}

}
