package gracefulsoul.problems;

public class SolvingQuestionsWithBrainpower {

	// https://leetcode.com/problems/solving-questions-with-brainpower/submissions/948951250/
	public static void main(String[] args) {
		SolvingQuestionsWithBrainpower test = new SolvingQuestionsWithBrainpower();
		System.out.println(test.mostPoints(new int[][] {
			{ 3, 2 },
			{ 4, 3 },
			{ 4, 4 },
			{ 2, 5 }
		}));
		System.out.println(test.mostPoints(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 },
			{ 4, 4 },
			{ 5, 5 }
		}));
	}

	public long mostPoints(int[][] questions) {
		int length = questions.length;
		long[] dp = new long[length + 1];
		for (int i = length - 1; i >= 0; i--) {
			dp[i] = Math.max(questions[i][0] + dp[Math.min(questions[i][1] + i + 1, length)], dp[i + 1]);
		}
		return dp[0];
	}

}
