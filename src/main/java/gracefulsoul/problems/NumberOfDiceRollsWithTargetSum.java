package gracefulsoul.problems;

public class NumberOfDiceRollsWithTargetSum {

	// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/1128529662/
	public static void main(String[] args) {
		NumberOfDiceRollsWithTargetSum test = new NumberOfDiceRollsWithTargetSum();
		System.out.println(test.numRollsToTarget(1, 6, 3));
		System.out.println(test.numRollsToTarget(2, 6, 7));
		System.out.println(test.numRollsToTarget(30, 30, 500));
	}

	public int numRollsToTarget(int n, int k, int target) {
		return this.numRollsToTarget(new int[n + 1][target + 1], n, k, target);
	}

	private int numRollsToTarget(int[][] dp, int n, int k, int target) {
		if (n == 0 && target == 0) {
			return 1;
		}
		if (target < n || n * k < target) {
			return 0;
		}
		if (dp[n][target] != 0) {
			return dp[n][target];
		}
		int result = 0;
		for (int i = 1; i <= k; i++) {
			if (target < i) {
				break;
			}
			result = (result + this.numRollsToTarget(dp, n - 1, k, target - i) % 1000000007) % 1000000007;
		}
		dp[n][target] = result;
		return result;
	}

}
