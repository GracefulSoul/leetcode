package gracefulsoul.problems;

public class MaximumNumberOfItemsFromSaleI {

	// https://leetcode.com/problems/maximum-number-of-items-from-sale-i/submissions/2204531705/
	public static void main(String[] args) {
		MaximumNumberOfItemsFromSaleI test = new MaximumNumberOfItemsFromSaleI();
		System.out.println(test.maximumSaleItems(new int[][] {
			{ 6, 2 },
			{ 2, 6 },
			{ 3, 4 }
		}, 9));
		System.out.println(test.maximumSaleItems(new int[][] {
			{ 2, 4 },
			{ 3, 2 },
			{ 4, 1 },
			{ 6, 4 },
			{ 12, 4 }
		}, 8));
	}

	public int maximumSaleItems(int[][] items, int budget) {
		int[] counts = new int[1501];
		for (int[] item : items) {
			int num = item[0];
			for (int i = 1; i <= 1500; i++) {
				if (num % i == 0) {
					counts[i]++;
				}
			}
		}
		int[] dp = new int[budget + 1];
		for (int[] item : items) {
			int factor = item[0];
			int price = item[1];
			int[] newDp = dp.clone();
			for (int i = budget; i >= price; i--) {
				newDp[i] = Math.max(newDp[i], dp[i - price] + counts[factor]);
			}
			for (int i = price; i <= budget; i++) {
				newDp[i] = Math.max(newDp[i], newDp[i - price] + 1);
			}
			dp = newDp;
		}
		int result = 0;
		for (int value : dp) {
			result = Math.max(result, value);
		}
		return result;
	}

}
