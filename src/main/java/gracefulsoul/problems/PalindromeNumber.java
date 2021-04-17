package gracefulsoul.problems;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
	}

	// https://leetcode.com/submissions/detail/481574918/
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

	// https://leetcode.com/submissions/detail/481576427/
//	public static boolean isPalindrome(int x) {
//		if (x < 0) {
//			return false;
//		} else {
//			int origin = x;
//			int reverse = 0;
//			while (x != 0) {
//				reverse = reverse * 10 + x % 10;
//				x /= 10;
//			}
//			return origin == reverse;
//		}
//	}

}
