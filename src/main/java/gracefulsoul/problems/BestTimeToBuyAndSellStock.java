package gracefulsoul.problems;

public class BestTimeToBuyAndSellStock {

	// https://leetcode.com/submissions/detail/536593819/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
		System.out.println(test.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(test.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int idx = 0; idx < prices.length; idx++) {
			if (prices[idx] < min) {
				min = prices[idx];
			}
			max = Math.max(max, prices[idx] - min);
		}
		return max;
	}

}
