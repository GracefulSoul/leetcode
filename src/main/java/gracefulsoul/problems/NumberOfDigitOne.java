package gracefulsoul.problems;

public class NumberOfDigitOne {

	// https://leetcode.com/submissions/detail/583711666/
	public static void main(String[] args) {
		NumberOfDigitOne test = new NumberOfDigitOne();
		System.out.println(test.countDigitOne(13));
		System.out.println(test.countDigitOne(0));
	}

	public int countDigitOne(int n) {
		int result = 0;
		for (int unit = 1; unit <= n; unit *= 10) {
			int quotient = n / unit;
			int remainder = n % unit;
			result += (((quotient + 8) / 10) * unit) + (quotient % 10 == 1 ? remainder + 1 : 0);
		}
		return result;
	}

}
