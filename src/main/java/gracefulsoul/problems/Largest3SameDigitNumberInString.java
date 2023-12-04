package gracefulsoul.problems;

public class Largest3SameDigitNumberInString {

	// https://leetcode.com/problems/largest-3-same-digit-number-in-string/submissions/1112121154/
	public static void main(String[] args) {
		Largest3SameDigitNumberInString test = new Largest3SameDigitNumberInString();
		System.out.println(test.largestGoodInteger("6777133339"));
		System.out.println(test.largestGoodInteger("2300019"));
		System.out.println(test.largestGoodInteger("42352338"));
	}

	public String largestGoodInteger(String num) {
		int result = -1;
		for (int i = 2; i < num.length(); i++) {
			if (num.charAt(i - 2) == num.charAt(i) && num.charAt(i - 1) == num.charAt(i)) {
				result = Math.max(result, num.charAt(i) - '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append((char) (48 + result));
		}
		return result == -1 ? "" : sb.toString();
	}

}
