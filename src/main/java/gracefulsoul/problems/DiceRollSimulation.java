package gracefulsoul.problems;

public class DiceRollSimulation {

	// https://leetcode.com/problems/dice-roll-simulation/submissions/1496918320/
	public static void main(String[] args) {
		DiceRollSimulation test = new DiceRollSimulation();
		System.out.println(test.dieSimulator(2, new int[] { 1, 1, 2, 2, 2, 3 }));
		System.out.println(test.dieSimulator(2, new int[] { 1, 1, 1, 1, 1, 1 }));
		System.out.println(test.dieSimulator(3, new int[] { 1, 1, 1, 2, 2, 3 }));
	}

	private static final int MOD = 1000000007;

	public int dieSimulator(int n, int[] rollMax) {
		long[][] dp = new long[n + 1][6];
		long[] sum = new long[n + 1];
		sum[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 1; k <= rollMax[j] && i - k >= 0; k++) {
					dp[i][j] = (dp[i][j] + sum[i - k] - dp[i - k][j] + MOD) % MOD;
				}
				sum[i] = (sum[i] + dp[i][j]) % MOD;
			}
		}
		return (int) sum[n];
	}

}
