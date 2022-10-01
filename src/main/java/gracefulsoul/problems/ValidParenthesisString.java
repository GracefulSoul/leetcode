package gracefulsoul.problems;

public class ValidParenthesisString {

	// https://leetcode.com/submissions/detail/812372966/
	public static void main(String[] args) {
		ValidParenthesisString test = new ValidParenthesisString();
		System.out.println(test.checkValidString("()"));
		System.out.println(test.checkValidString("(*)"));
		System.out.println(test.checkValidString("())"));
	}

	public boolean checkValidString(String s) {
		int min = 0;
		int max = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
				case '(':
					max++;
					min++;
					break;
				case ')':
					max--;
					min--;
					break;
				case '*':
					max++;
					min--;
					break;
			}
			if (max < 0) {
				return false;
			}
			min = Math.max(min, 0);
		}
		return min == 0;
	}

}
