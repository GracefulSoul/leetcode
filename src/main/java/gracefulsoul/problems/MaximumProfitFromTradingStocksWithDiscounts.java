package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumProfitFromTradingStocksWithDiscounts {

	// https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/submissions/1856898967/
	public static void main(String[] args) {
		MaximumProfitFromTradingStocksWithDiscounts test = new MaximumProfitFromTradingStocksWithDiscounts();
		System.out.println(test.maxProfit(2,
				new int[] { 1, 2 },
				new int[] { 4, 3 },
				new int[][] {
					{ 1, 2 }
				}, 0));
		System.out.println(test.maxProfit(2,
				new int[] { 3, 4 },
				new int[] { 5, 8 },
				new int[][] {
					{ 1, 2 }
				}, 4));
		System.out.println(test.maxProfit(3,
				new int[] { 4, 6, 8 },
				new int[] { 7, 9, 11 },
				new int[][] {
					{ 1, 2 },
					{ 1, 3 }
				}, 10));
		System.out.println(test.maxProfit(3,
				new int[] { 5, 2, 3 },
				new int[] { 8, 5, 6 },
				new int[][] {
					{ 1, 2 },
					{ 2, 3 }
				}, 7));
	}

	public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
		List<List<Integer>> tree = new ArrayList<>();
		int[] curr = present;
		int[] last = future;
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		for (int[] relation : hierarchy) {
			tree.get(relation[0]).add(relation[1]);
		}
		int[][] result = this.dfs(tree, curr, last, budget, 1);
		int maxProfit = 0;
		for (int value : result[0]) {
			maxProfit = Math.max(maxProfit, value);
		}
		return maxProfit;
	}

	private int[][] dfs(List<List<Integer>> tree, int[] curr, int[] last, int budget, int u) {
		int[][] result = new int[2][budget + 1];
		int min = -1000000000;
		Arrays.fill(result[0], min);
		Arrays.fill(result[1], min);
		int[][] dp = new int[2][budget + 1];
		Arrays.fill(dp[0], min);
		Arrays.fill(dp[1], min);
		dp[0][0] = 0;
		dp[1][0] = 0;
		for (int value : tree.get(u)) {
			int[][] childrens = this.dfs(tree, curr, last, budget, value);
			dp[0] = this.merge(dp[0], childrens[0], budget, min);
			dp[1] = this.merge(dp[1], childrens[1], budget, min);
		}
		int price = curr[u - 1];
		int profit = last[u - 1] - price;
		for (int i = 0; i <= budget; i++) {
			if (dp[0][i] != min) {
				result[0][i] = Math.max(result[0][i], dp[0][i]);
			}
			if (i >= price && dp[1][i - price] != min) {
				result[0][i] = Math.max(result[0][i], dp[1][i - price] + profit);
			}
		}
		int halfPrice = price / 2;
		int halfProfit = last[u - 1] - halfPrice;
		for (int i = 0; i <= budget; i++) {
			if (dp[0][i] != min) {
				result[1][i] = Math.max(result[1][i], dp[0][i]);
			}
			if (i >= halfPrice && dp[1][i - halfPrice] != min) {
				result[1][i] = Math.max(result[1][i], dp[1][i - halfPrice] + halfProfit);
			}
		}
		return result;
	}

	private int[] merge(int[] dp, int[] children, int budget, int min) {
		int[] next = new int[budget + 1];
		Arrays.fill(next, min);
		for (int i = budget; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (dp[i - j] != min && children[j] != min) {
					next[i] = Math.max(next[i], dp[i - j] + children[j]);
				}
			}
		}
		return next;
	}

}
