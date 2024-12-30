package gracefulsoul.problems;

public class NumberOfWaysToFormATargetStringGivenADictionary {

	// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/submissions/1491301276/
	public static void main(String[] args) {
		NumberOfWaysToFormATargetStringGivenADictionary test = new NumberOfWaysToFormATargetStringGivenADictionary();
		System.out.println(test.numWays(new String[] { "acca", "bbbb", "caca" }, "aba"));
		System.out.println(test.numWays(new String[] { "abba", "baab" }, "bab"));
	}

	private static final int MOD = 1000000007;

	public int numWays(String[] words, String target) {
		int length = target.length();
		long[] dp = new long[length + 1];
		dp[0] = 1;
		for (int i = 0; i < words[0].length(); i++) {
			int[] count = new int[26];
			for (String word : words) {
				count[word.charAt(i) - 'a']++;
			}
			for (int j = length - 1; j >= 0; j--) {
				dp[j + 1] += (dp[j] * count[target.charAt(j) - 'a']) % MOD;
			}
		}
		return (int) (dp[length] % MOD);
	}

}
