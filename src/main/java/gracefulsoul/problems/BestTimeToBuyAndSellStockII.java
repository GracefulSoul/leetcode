package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockII {

	// https://leetcode.com/submissions/detail/537161438/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII test = new BestTimeToBuyAndSellStockII();
		System.out.println(test.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(test.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public int maxProfit(int[] prices) {
		int idx = 0;
		int sum = 0;
		int min = 0;
		while (idx < prices.length) {
			while (idx < prices.length - 1 && prices[idx] >= prices[idx + 1]) {
				idx++;
			}
			min = prices[idx++];
			while (idx < prices.length - 1 && prices[idx] <= prices[idx + 1]) {
				idx++;
			}
			sum += prices.length > idx ? prices[idx++] - min : 0;
		}
		return sum;
	}

}
