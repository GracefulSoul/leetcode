package gracefulsoul.problems;

public class NthDigit {

	// https://leetcode.com/submissions/detail/650219323/
	public static void main(String[] args) {
		NthDigit test = new NthDigit();
		System.out.println(test.findNthDigit(3));
		System.out.println(test.findNthDigit(11));
	}

	public int findNthDigit(int n) {
		int length = 1;
		int base = 1;
		while (n > 9L * base * length) {
			n -= 9 * base * length;
			length++;
			base *= 10;
		}
		int result = 0;
		int num = (n - 1) / length + base;
		for (int idx = (n - 1) % length; idx < length; idx++) {
			result = num % 10;
			num /= 10;
		}
		return result;
	}

}
