package gracefulsoul.problems;

public class ValidPalindromeII {

	// https://leetcode.com/submissions/detail/813821139/
	public static void main(String[] args) {
		ValidPalindromeII test = new ValidPalindromeII();
		System.out.println(test.validPalindrome("aba"));
		System.out.println(test.validPalindrome("abca"));
		System.out.println(test.validPalindrome("abc"));
	}

	public boolean validPalindrome(String s) {
		char[] charArray = s.toCharArray();
		int length = s.length();
		int index = this.isPalindrome(charArray, 0, length - 1);
		if (index == -1) {
			return true;
		} else {
			return this.isPalindrome(charArray, index + 1, length - index - 1) == -1
					|| this.isPalindrome(charArray, index, length - index - 2) == -1;
		}
	}

	private int isPalindrome(char[] charArray, int left, int right) {
		while (left < right) {
			if (charArray[left] != charArray[right]) {
				return left;
			}
			left++;
			right--;
		}
		return -1;
	}

}
