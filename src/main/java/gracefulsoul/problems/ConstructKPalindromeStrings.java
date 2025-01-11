package gracefulsoul.problems;

public class ConstructKPalindromeStrings {

	// https://leetcode.com/problems/construct-k-palindrome-strings/submissions/1504618593/
	public static void main(String[] args) {
		ConstructKPalindromeStrings test = new ConstructKPalindromeStrings();
		System.out.println(test.canConstruct("annabelle", 2));
		System.out.println(test.canConstruct("leetcode", 3));
		System.out.println(test.canConstruct("true", 4));
	}

	public boolean canConstruct(String s, int k) {
		if (s.length() > k) {
			int odd = 0;
			for (char c : s.toCharArray()) {
				odd ^= 1 << (c - 'a');
			}
			return Integer.bitCount(odd) <= k;
		} else {
			return s.length() == k;
		}
	}

}
