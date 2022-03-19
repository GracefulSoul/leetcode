package gracefulsoul.problems;

public class StrongPasswordChecker {

	public static void main(String[] args) {
		StrongPasswordChecker test = new StrongPasswordChecker();
		System.out.println(test.strongPasswordChecker("a"));
		System.out.println(test.strongPasswordChecker("aA1"));
		System.out.println(test.strongPasswordChecker("1337C0d3"));
	}

	public int strongPasswordChecker(String password) {
		int length = password.length();
		if (length < 6) {
			return Math.max(this.passwordCheck(password), 6 - length);
		}
		int count = 0;
		int oneChar = 0;
		int twoChars = 0;
		for (int idx = 0; idx < length; idx++) {
			char c = password.charAt(idx);
			int charLength = 1;
			while (length > idx + 1 && c == password.charAt(idx + 1)) {
				idx++;
				charLength++;
			}
			if (charLength >= 3) {
				count += (charLength) / 3;
				if (charLength % 3 == 0) {
					oneChar++;
				} else if (charLength % 3 == 1) {
					twoChars++;
				}
			}
		}
		if (length >= 6 && length <= 20) {
			return Math.max(this.passwordCheck(password), count);
		}
		int deleted = length - 20;
		count -= Math.min(deleted, oneChar);
		count -= Math.min(Math.max(deleted - oneChar, 0), twoChars * 2) / 2;
		count -= Math.max(deleted - oneChar - 2 * twoChars, 0) / 3;
		return deleted + Math.max(this.passwordCheck(password), count);
	}

	private int passwordCheck(String password) {
		int isContainLowerCase = 1;
		int isContainUpperCase = 1;
		int isContainDigit = 1;
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				isContainDigit = 0;
			} else if (Character.isLowerCase(c)) {
				isContainLowerCase = 0;
			} else if (Character.isUpperCase(c)) {
				isContainUpperCase = 0;
			}
		}
		return isContainLowerCase + isContainUpperCase + isContainDigit;
	}

}
