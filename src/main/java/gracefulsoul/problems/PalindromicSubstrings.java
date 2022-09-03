package gracefulsoul.problems;

public class PalindromicSubstrings {

	// https://leetcode.com/submissions/detail/790845435/
	public static void main(String[] args) {
		PalindromicSubstrings test = new PalindromicSubstrings();
		System.out.println(test.countSubstrings("abc"));
		System.out.println(test.countSubstrings("aaa"));
	}

	public int countSubstrings(String s) {
		int count = 0;
		char[] charArray = s.toCharArray();
		for (int idx = 0; idx < s.length(); idx++) {
			count += this.isPalindrome(charArray, idx, idx);
			count += this.isPalindrome(charArray, idx, idx + 1);
		}
		return count;
	}

	private int isPalindrome(char[] charArray, int start, int end) {
		int count = 0;
		while (start >= 0 && end < charArray.length && charArray[start] == charArray[end]) {
			count++;
			start--;
			end++;
		}
		return count;
	}

}
