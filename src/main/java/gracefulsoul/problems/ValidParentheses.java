package gracefulsoul.problems;

import java.util.Stack;

public class ValidParentheses {

	// https://leetcode.com/submissions/detail/487044545/
	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("()"));
		System.out.println(test.isValid("()[]{}"));
		System.out.println(test.isValid("(]"));
		System.out.println(test.isValid("([)]"));
		System.out.println(test.isValid("{[]}"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || !stack.pop().equals('(')) {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || !stack.pop().equals('{')) {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || !stack.pop().equals('[')) {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

}
