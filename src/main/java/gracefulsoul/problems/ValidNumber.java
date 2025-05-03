package gracefulsoul.problems;

public class ValidNumber {

	// https://leetcode.com/problems/valid-number/submissions/1623502311/
	public static void main(String[] args) {
		ValidNumber test = new ValidNumber();
		System.out.println(test.isNumber("0"));
		System.out.println(test.isNumber("e"));
		System.out.println(test.isNumber("."));
	}

	public boolean isNumber(String s) {
		char[] charArray = s.toCharArray();
		boolean seenNumber = false;
		boolean seenExponent = false;
		boolean seenDot = false;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case '.':
					if (seenDot || seenExponent) {
						return false;
					} else {
						seenDot = true;
						break;
					}
				case 'e': case 'E':
					if (seenExponent || !seenNumber) {
						return false;
					} else {
						seenExponent = true;
						seenNumber = false;
						break;
					}
				case '+': case '-':
					if (i != 0 && (charArray[i - 1] != 'e' && charArray[i - 1] != 'E')) {
						return false;
					} else {
						seenNumber = false;
						break;
					}
				default:
					if (charArray[i] - '0' < 0 || charArray[i] - '0' > 9) {
						return false;
					} else {
						seenNumber = true;
					}
			}
		}
		return seenNumber;
	}

}
