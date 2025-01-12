package gracefulsoul.problems;

public class CheckIfAParenthesesStringCanBeValid {

	// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/submissions/1505920479/
	public static void main(String[] args) {
		CheckIfAParenthesesStringCanBeValid test = new CheckIfAParenthesesStringCanBeValid();
		System.out.println(test.canBeValid("))()))", "010100"));
		System.out.println(test.canBeValid("()()", "0000"));
		System.out.println(test.canBeValid(")", "0"));
		System.out.println(test.canBeValid("()", "11"));
	}

	public boolean canBeValid(String s, String locked) {
		int length = s.length();
		if (length % 2 == 1) {
			return false;
		}
		int open = 0;
		int close = 0;
		for (int i = 0; i < length; i++) {
			if (locked.charAt(i) == '1') {
				if (s.charAt(i) == '(') {
					open++;
					close++;
				} else {
					open--;
					close--;
				}
			} else {
				open++;
				close--;
			}
			if (close < 0) {
				close += 2;
			}
			if (open < 0) {
				return false;
			}
		}
		return close == 0;
	}

}
