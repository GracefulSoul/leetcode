package gracefulsoul.problems;

public class MinimumDifficultyOfAJobSchedule {

	// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/submissions/1131028308/
	public static void main(String[] args) {
		MinimumDifficultyOfAJobSchedule test = new MinimumDifficultyOfAJobSchedule();
		System.out.println(test.minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 2));
		System.out.println(test.minDifficulty(new int[] { 9, 9, 9 }, 4));
		System.out.println(test.minDifficulty(new int[] { 1, 1, 1 }, 3));
	}

	public int minDifficulty(int[] jobDifficulty, int d) {
		int length = jobDifficulty.length;
		if (d > length) {
			return -1;
		}
		int[] dp = new int[length + 1];
		for (int i = 0; i < length; i++) {
			dp[i + 1] = Math.max(dp[i], jobDifficulty[i]);
		}
		for (int j = 2; j <= d; j++) {
			for (int i = length; i >= 1; i--) {
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				for (int k = i - 1; k >= j - 1; k--) {
					max = Math.max(max, jobDifficulty[k]);
					min = Math.min(min, dp[k] + max);
				}
				dp[i] = min;
			}
		}
		return dp[length];
	}

}
