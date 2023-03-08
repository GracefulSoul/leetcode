package gracefulsoul.problems;

public class PrimePalindrome {

	// https://leetcode.com/problems/prime-palindrome/submissions/911408509/
	public static void main(String[] args) {
		PrimePalindrome test = new PrimePalindrome();
		System.out.println(test.primePalindrome(6));
		System.out.println(test.primePalindrome(8));
		System.out.println(test.primePalindrome(13));
	}

	public int primePalindrome(int n) {
		if (n >= 8 && n <= 11) {
			return 11;
		} else {
			for (int i = n; i <= 100000000; i++) {
				String s = String.valueOf(i);
				int length = s.length();
				if (length % 2 == 0) {
					i = (int) Math.pow(10, (double) length);
				} else if (isPalindrome(i) && isPrime(i)) {
					return i;
				}
			}
			return 100030001;
		}
	}

	private boolean isPalindrome(int n) {
		if (n % 10 == 0) {
			return false;
		} else {
			int revert = 0;
			while (n > revert) {
				revert = revert * 10 + n % 10;
				n /= 10;
			}
			return revert == n || n == revert / 10;
		}
	}

	private boolean isPrime(int n) {
		if (n < 2 || n % 2 == 0) {
			return n == 2;
		} else {
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
