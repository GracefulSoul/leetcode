package gracefulsoul.problems;

public class WaysToExpressAnIntegerAsSumOfPowers {

	// https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/submissions/1732245791/
	public static void main(String[] args) {
		WaysToExpressAnIntegerAsSumOfPowers test = new WaysToExpressAnIntegerAsSumOfPowers();
		System.out.println(test.numberOfWays(10, 2));
		System.out.println(test.numberOfWays(4, 1));
	}

	public int numberOfWays(int n, int x) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		int power;
		for (int i = 1; (power = (int) Math.pow(i, x)) <= n; i++) {
			for (int sum = n; power <= sum; sum--) {
				dp[sum] = (dp[sum] + dp[sum - power]) % 1000000007;
			}
		}
		return dp[n];
	}

}
