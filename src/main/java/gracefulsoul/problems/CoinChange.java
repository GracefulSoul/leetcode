package gracefulsoul.problems;

import java.util.Arrays;

public class CoinChange {

	// https://leetcode.com/submissions/detail/610172871/
	public static void main(String[] args) {
		CoinChange test = new CoinChange();
		System.out.println(test.coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(test.coinChange(new int[] { 2 }, 3));
		System.out.println(test.coinChange(new int[] { 1 }, 0));
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int idx = 0; idx < amount + 1; idx++) {
			for (int coin : coins) {
				if (idx >= coin)
					dp[idx] = Math.min(dp[idx], 1 + dp[idx - coin]);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

}
