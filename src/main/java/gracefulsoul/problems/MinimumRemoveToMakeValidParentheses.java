package gracefulsoul.problems;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/1224619191/
	public static void main(String[] args) {
		MinimumRemoveToMakeValidParentheses test = new MinimumRemoveToMakeValidParentheses();
		System.out.println(test.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(test.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(test.minRemoveToMakeValid("))(("));
	}

	public String minRemoveToMakeValid(String s) {
		char[] charArray = s.toCharArray();
		int open = 0;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case '(': open++; break;
				case ')':
					if (open == 0) {
						charArray[i] = '.';
					} else {
						open--;
					}
					break;
				default: break;
			}
		}
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (open > 0 && charArray[i] == '(') {
				charArray[i] = '.';
				open--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (c != '.') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
