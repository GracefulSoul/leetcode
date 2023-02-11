package gracefulsoul.problems;

public class New21Game {

	// https://leetcode.com/problems/new-21-game/submissions/896388326/
	public static void main(String[] args) {
		New21Game test = new New21Game();
		System.out.println(test.new21Game(10, 1, 10));
		System.out.println(test.new21Game(6, 1, 10));
		System.out.println(test.new21Game(21, 17, 10));
	}

	public double new21Game(int n, int k, int maxPts) {
		if (k == 0 || n >= k + maxPts) {
			return 1;
		}
		double[] dp = new double[n + 1];
		dp[0] = 1;
		double sum = 1;
		double result = 0;
		for (int idx = 1; idx <= n; idx++) {
			dp[idx] = sum / maxPts;
			if (idx < k) {
				sum += dp[idx];
			} else {
				result += dp[idx];
			}
			if (idx >= maxPts) {
				sum -= dp[idx - maxPts];
			}
		}
		return result;
	}

}
