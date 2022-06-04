package gracefulsoul.problems;

public class CoinChange2 {

	// https://leetcode.com/submissions/detail/713881945/
	public static void main(String[] args) {
		CoinChange2 test = new CoinChange2();
		System.out.println(test.change(5, new int[] { 1, 2, 5 }));
		System.out.println(test.change(3, new int[] { 2 }));
		System.out.println(test.change(10, new int[] { 10 }));
	}

	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int idx = coin; idx <= amount; idx++) {
				dp[idx] += dp[idx - coin];
			}
		}
		return dp[amount];
	}

}
