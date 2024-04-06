package gracefulsoul.problems;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/1224600190/
	public static void main(String[] args) {
		MinimumRemoveToMakeValidParentheses test = new MinimumRemoveToMakeValidParentheses();
		System.out.println(test.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(test.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(test.minRemoveToMakeValid("))(("));
	}

	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < sb.length(); i++) {
			switch (sb.charAt(i)) {
				case '(':
					stack.add(i);
					break;
				case ')':
					if (!stack.empty()) {
						stack.pop();
					} else {
						sb.setCharAt(i, '.');
					}
					break;
			}
		}
		while (!stack.empty()) {
			sb.setCharAt(stack.pop(), '.');
		}
		return sb.toString().replaceAll("\\.", "");
	}

}
