package gracefulsoul.problems;

public class SumOfKMirrorNumbers {

	// https://leetcode.com/problems/sum-of-k-mirror-numbers/submissions/1673551462/
	public static void main(String[] args) {
		SumOfKMirrorNumbers test = new SumOfKMirrorNumbers();
		System.out.println(test.kMirror(2, 5));
		System.out.println(test.kMirror(3, 7));
		System.out.println(test.kMirror(7, 17));
	}

	public long kMirror(int k, int n) {
		long sum = 0;
		for (long length = 1; n > 0; length *= 10) {
			for (long i = length; n > 0 && i < length * 10; i++) {
				long palindrome = this.createPalindrome(i, true);
				if (this.isPalindrome(palindrome, k)) {
					sum += palindrome;
					n--;
				}
			}
			for (long i = length; n > 0 && i < length * 10; i++) {
				long palindrome = this.createPalindrome(i, false);
				if (this.isPalindrome(palindrome, k)) {
					sum += palindrome;
					n--;
				}
			}
		}
		return sum;
	}

	private long createPalindrome(long num, boolean odd) {
		long x = num;
		if (odd) {
			x /= 10;
		}
		while (x > 0) {
			num = (num * 10) + (x % 10);
			x /= 10;
		}
		return num;
	}

	private boolean isPalindrome(long num, int base) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append((char) (num % base + '0'));
			num /= base;
		}
		String s = sb.toString();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
