package gracefulsoul.problems;

public class ShortestPalindrome {

	// https://leetcode.com/submissions/detail/573448815/
	public static void main(String[] args) {
		ShortestPalindrome test = new ShortestPalindrome();
		System.out.println(test.shortestPalindrome("aacecaaa"));
		System.out.println(test.shortestPalindrome("abcd"));
	}

	public String shortestPalindrome(String s) {
		int start = 0;
		for (int end = s.length() - 1; end >= 0; end--) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
			}
		}
		if (start == s.length()) {
			return s;
		}
		String str = s.substring(start);
		return new StringBuilder(str)
				.reverse()
				.append(this.shortestPalindrome(s.substring(0, start)))
				.append(str)
				.toString();
	}

}
