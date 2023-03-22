package gracefulsoul.problems;

public class DecodedStringAtIndex {

	// https://leetcode.com/problems/decoded-string-at-index/submissions/920080269/
	public static void main(String[] args) {
		DecodedStringAtIndex test = new DecodedStringAtIndex();
		System.out.println(test.decodeAtIndex("leet2code3", 10));
		System.out.println(test.decodeAtIndex("ha22", 5));
		System.out.println(test.decodeAtIndex("a2345678999999999999999", 1));
	}

	public String decodeAtIndex(String s, int k) {
		int i = 0;
		long n = 0;
		for (; n < k; i++) {
			if (Character.isDigit(s.charAt(i))) {
				n *= s.charAt(i) - '0';
			} else {
				n++;
			}
		}
		while (--i > 0) {
			if (Character.isDigit(s.charAt(i))) {
				n /= s.charAt(i) - '0';
				k %= n;
			} else {
				if (k % n == 0) {
					break;
				} else {
					n--;
				}
			}
		}
		return Character.toString(s.charAt(i));
	}

}
