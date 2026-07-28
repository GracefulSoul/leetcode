package gracefulsoul.problems;

public class SmallestPalindromicRearrangementI {

	// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/submissions/2084658147/
	public static void main(String[] args) {
		SmallestPalindromicRearrangementI test = new SmallestPalindromicRearrangementI();
		System.out.println(test.smallestPalindrome("z"));
		System.out.println(test.smallestPalindrome("babab"));
		System.out.println(test.smallestPalindrome("daccad"));
	}

	public String smallestPalindrome(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[] counts = new int[26];
		for (int i = 0; i < length >> 1; i++) {
			counts[(charArray[i] & 31) - 1]++;
		}
		for (int i = 0, j = 0; i < 26; i++) {
			char c = (char) (97 + i);
			while (counts[i]-- > 0) {
				charArray[j] = c;
				charArray[length - 1 - j++] = c;
			}
		}
		return new String(charArray);
	}

}
