package gracefulsoul.problems;

public class MostProfitAssigningWork {

	// https://leetcode.com/problems/most-profit-assigning-work/submissions/889993698/
	public static void main(String[] args) {
		MostProfitAssigningWork test = new MostProfitAssigningWork();
		System.out.println(test.maxProfitAssignment(new int[] { 2, 4, 6, 8, 10 }, new int[] { 10, 20, 30, 40, 50 }, new int[] { 4, 5, 6, 7 }));
		System.out.println(test.maxProfitAssignment(new int[] { 85, 47, 57 }, new int[] { 24, 66, 99 }, new int[] { 40, 25, 25 }));
	}

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int[] dp = new int[100001];
		for (int idx = 0; idx < difficulty.length; idx++) {
			dp[difficulty[idx]] = Math.max(dp[difficulty[idx]], profit[idx]);
		}
		for (int idx = 1; idx < dp.length; idx++) {
			dp[idx] = Math.max(dp[idx - 1], dp[idx]);
		}
		int result = 0;
		for (int ability : worker) {
			result += dp[ability];
		}
		return result;
	}

}
