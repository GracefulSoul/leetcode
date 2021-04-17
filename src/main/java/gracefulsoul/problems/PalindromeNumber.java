package gracefulsoul.problems;

public class PalindromeNumber {

	// https://leetcode.com/submissions/detail/481574918/
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		} else {
			int reverse = 0;
			while (x > reverse) {
				reverse = reverse * 10 + x % 10;
				x /= 10;
			}
			return x == reverse || x == reverse / 10;
		}
	}

}
