package gracefulsoul.problems;

public class LongestPalindromebyConcatenatingTwoLetterWords {

	// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/submissions/1643527331/
	public static void main(String[] args) {
		LongestPalindromebyConcatenatingTwoLetterWords test = new LongestPalindromebyConcatenatingTwoLetterWords();
		System.out.println(test.longestPalindrome(new String[] { "lc", "cl", "gg" }));
		System.out.println(test.longestPalindrome(new String[] { "ab", "ty", "yt", "lc", "cl", "ab" }));
		System.out.println(test.longestPalindrome(new String[] { "cc", "ll", "xx" }));
	}

	public int longestPalindrome(String[] words) {
		int[][] counts = new int[26][26];
		int result = 0;
		for (String word : words) {
			int c1 = word.charAt(0) - 'a';
			int c2 = word.charAt(1) - 'a';
			if (counts[c2][c1] == 0) {
				counts[c1][c2]++;
			} else {
				result += 4;
				counts[c2][c1]--;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (counts[i][i] > 0) {
				result += 2;
				break;
			}
		}
		return result;
	}

}
