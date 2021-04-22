package gracefulsoul.problems;

public class LongestPalindromicSubstring {

	// https://leetcode.com/submissions/detail/480056605/
	public static void main(String[] args) {
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		System.out.println(test.longestPalindrome("babad"));
		System.out.println(test.longestPalindrome("cbbd"));
		System.out.println(test.longestPalindrome("a"));
		System.out.println(test.longestPalindrome("ac"));

	}

	public String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(this.expandAroundCenter(s, i, i), this.expandAroundCenter(s, i, i + 1));
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
