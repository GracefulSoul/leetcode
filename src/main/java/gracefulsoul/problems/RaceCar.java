package gracefulsoul.problems;

public class RaceCar {

	// https://leetcode.com/problems/race-car/submissions/886225139/
	public static void main(String[] args) {
		RaceCar test = new RaceCar();
		System.out.println(test.racecar(3));
		System.out.println(test.racecar(6));
	}

	public int racecar(int target) {
		int bound = 0;
		while (bound < target) {
			bound = (bound * 2) + 1;
		}
		int[] dp = new int[bound + 1];
		for (int i = 0, j = 0; j <= bound; i++, j = (j * 2) + 1) {
			dp[j] = i;
		}
		return this.dfs(target, dp);
	}

	private int dfs(int target, int[] dp) {
		if (dp[target] > 0) {
			return dp[target];
		}
		int bound = 0;
		while (bound < target) {
			bound = (bound * 2) + 1;
		}
		dp[target] = dp[bound] + 1 + this.dfs(bound - target, dp);
		bound = (bound - 1) / 2;
		for (int idx = 0; idx < bound; idx = (idx * 2) + 1) {
			dp[target] = Math.min(dp[target], dp[bound] + 1 + dp[idx] + 1 + this.dfs(target - bound + idx, dp));
		}
		return dp[target];
	}

}
