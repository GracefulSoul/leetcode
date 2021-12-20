package gracefulsoul.problems;

public class BestTimeToBuyAndSellStockWithCooldown {

	// https://leetcode.com/submissions/detail/604340980/
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
		System.out.println(test.maxProfit(new int[] { 1, 2, 3, 0, 2 }));
		System.out.println(test.maxProfit(new int[] { 1 }));
	}

	public int maxProfit(int[] prices) {
		int sold = 0;
		int hold = Integer.MIN_VALUE;
		int rest = 0;
		for (int price : prices) {
			hold = Math.max(hold, rest - price);
			rest = Math.max(rest, sold);
			sold = hold + price;
		}
		return Math.max(sold, rest);
	}

}
