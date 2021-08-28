package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	// https://leetcode.com/submissions/detail/545383870/
	public static void main(String[] args) {
		WordBreak test = new WordBreak();
		System.out.println(test.wordBreak("leetcode", Arrays.asList("leet", "code")));
		System.out.println(test.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(test.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		Set<String> wordSet = new HashSet<>();
		wordSet.addAll(wordDict);
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
				if (dp[i]) {
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
