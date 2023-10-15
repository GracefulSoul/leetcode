package gracefulsoul.problems;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

	// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/submissions/1075667008/
	public static void main(String[] args) {
		NumberOfWaysToStayInTheSamePlaceAfterSomeSteps test = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();
		System.out.println(test.numWays(3, 2));
		System.out.println(test.numWays(2, 4));
		System.out.println(test.numWays(4, 2));
	}

	public int numWays(int steps, int arrLen) {
		int length = Math.min(steps, arrLen);
		long[][] dp = new long[steps + 1][length + 1];
		dp[0][0] = 1;
		for (int i = 0; i < steps; i++) {
			for (int j = 0; j < length; j++) {
				dp[i + 1][j] = (dp[i][j] + dp[i][j + 1] + (j > 0 ? dp[i][j - 1] : 0)) % 1000000007;
			}
		}
		return (int) dp[steps][0];
	}

}
