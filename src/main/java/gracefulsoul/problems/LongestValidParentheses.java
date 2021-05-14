package gracefulsoul.problems;

import java.util.Stack;

public class LongestValidParentheses {

	// https://leetcode.com/submissions/detail/493237946/
	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		System.out.println(test.longestValidParentheses("(()"));
		System.out.println(test.longestValidParentheses(")()())"));
		System.out.println(test.longestValidParentheses(""));
	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			if (s.charAt(idx) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
				result = Math.max(result, stack.isEmpty() ? idx + 1 : idx - stack.peek());
			} else {
				stack.push(idx);
			}
		}
		return result;
	}

}
