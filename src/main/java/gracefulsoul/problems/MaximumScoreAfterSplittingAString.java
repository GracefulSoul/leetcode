package gracefulsoul.problems;

public class MaximumScoreAfterSplittingAString {

	// https://leetcode.com/problems/maximum-score-after-splitting-a-string/submissions/1126216951/
	public static void main(String[] args) {
		MaximumScoreAfterSplittingAString test = new MaximumScoreAfterSplittingAString();
		System.out.println(test.maxScore("011101"));
		System.out.println(test.maxScore("00111"));
		System.out.println(test.maxScore("1111"));
	}

	public int maxScore(String s) {
		int zeros = 0;
		int ones = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zeros++;
			} else {
				ones++;
			}
			if (i != s.length() - 1) {
				max = Math.max(zeros - ones, max);
			}
		}
		return max + ones;
	}

}
