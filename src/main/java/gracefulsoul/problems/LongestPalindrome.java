package gracefulsoul.problems;

public class LongestPalindrome {

	// https://leetcode.com/submissions/detail/655534901/
	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.longestPalindrome("abccccdd"));
		System.out.println(test.longestPalindrome("a"));
		System.out.println(test.longestPalindrome("bb"));
	}

	public int longestPalindrome(String s) {
		int[] count = new int[58];
		for (char c : s.toCharArray()) {
			count[c - 'A']++;
		}
		int length = 0;
		boolean isOdd = false;
		for (int idx = 0; idx < 58; idx++) {
			length += count[idx];
			if (count[idx] % 2 == 1) {
				length--;
				isOdd = true;
			}
		}
		return length + (isOdd ? 1 : 0);
	}

}
