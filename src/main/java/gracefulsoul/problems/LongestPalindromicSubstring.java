package gracefulsoul.problems;

public class LongestPalindromicSubstring {

	// https://leetcode.com/submissions/detail/480056605/
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("ac"));

	}

	public static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
