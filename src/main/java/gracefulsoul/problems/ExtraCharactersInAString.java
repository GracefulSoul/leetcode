package gracefulsoul.problems;

public class ExtraCharactersInAString {

	// https://leetcode.com/problems/extra-characters-in-a-string/submissions/1038290323/
	public static void main(String[] args) {
		ExtraCharactersInAString test = new ExtraCharactersInAString();
		System.out.println(test.minExtraChar("leetscode", new String[] { "leet", "code", "leetcode" }));
		System.out.println(test.minExtraChar("sayhelloworld", new String[] { "hello", "world" }));
	}

	public int minExtraChar(String s, String[] dictionary) {
		int length = s.length();
		int[] dp = new int[length + 1];
		for (int i = length - 1; i >= 0; i--) {
			String str = s.substring(i);
			dp[i] = dp[i + 1] + 1;
			for (int j = 0; j < dictionary.length; j++) {
				if (str.startsWith(dictionary[j])) {
					dp[i] = Math.min(dp[i], dp[i + dictionary[j].length()]);
				}
			}
		}
		return dp[0];
	}

}
