package gracefulsoul.problems;

public class ScoreOfAString {

	// https://leetcode.com/problems/score-of-a-string/submissions/1273785276/
	public static void main(String[] args) {
		ScoreOfAString test = new ScoreOfAString();
		System.out.println(test.scoreOfString("hello"));
		System.out.println(test.scoreOfString("zaz"));
	}

	public int scoreOfString(String s) {
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			result += Math.abs(s.charAt(i) - s.charAt(i + 1));
		}
		return result;
	}

}
