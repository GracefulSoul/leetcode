package gracefulsoul.problems;

public class SuperPalindromes {

	// https://leetcode.com/problems/super-palindromes/submissions/937721694/
	public static void main(String[] args) {
		SuperPalindromes test = new SuperPalindromes();
		System.out.println(test.superpalindromesInRange("4", "1000"));
		System.out.println(test.superpalindromesInRange("1", "2"));
	}

	public int superpalindromesInRange(String left, String right) {
		int result = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
		for (int i = 1; i < 19684; i++) {
			String num = Integer.toString(i, 3);
			if (this.isPalindrome(num)) {
				long square = Long.parseLong(num) * Long.parseLong(num);
				if (square > Long.parseLong(right)) {
					return result;
				}
				if (square >= Long.parseLong(left) && this.isPalindrome(Long.toString(square))) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
