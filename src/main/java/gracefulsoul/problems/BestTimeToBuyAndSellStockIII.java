package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockIII {

	// https://leetcode.com/submissions/detail/537663413/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
		System.out.println(test.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
		System.out.println(test.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public int maxProfit(int[] prices) {
		int[] buy = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
		int[] sell = new int[2];
		for (int price : prices) {
			buy[0] = Math.min(buy[0], price);
			sell[0] = Math.max(sell[0], price - buy[0]);
			buy[1] = Math.min(buy[1], price - sell[0]);
			sell[1] = Math.max(sell[1], price - buy[1]);
		}
		return sell[1];
	}

}
