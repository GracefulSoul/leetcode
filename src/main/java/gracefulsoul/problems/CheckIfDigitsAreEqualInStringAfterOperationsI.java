package gracefulsoul.problems;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

	// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/submissions/1809273405/
	public static void main(String[] args) {
		CheckIfDigitsAreEqualInStringAfterOperationsI test = new CheckIfDigitsAreEqualInStringAfterOperationsI();
		System.out.println(test.hasSameDigits("3902"));
		System.out.println(test.hasSameDigits("34789"));
	}

	public boolean hasSameDigits(String s) {
		char[] charArray = s.toCharArray();
		for (int i = charArray.length - 1; i >= 2; i--) {
			for (int j = 0; j < i; j++) {
				charArray[j] = (char) ((charArray[j] + charArray[j + 1]) % 10);
			}
		}
		return charArray[0] == charArray[1];
	}

}
