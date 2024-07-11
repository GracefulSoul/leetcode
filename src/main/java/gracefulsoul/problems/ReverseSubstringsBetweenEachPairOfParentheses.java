package gracefulsoul.problems;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

	// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/submissions/1317362151/
	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairOfParentheses test = new ReverseSubstringsBetweenEachPairOfParentheses();
		System.out.println(test.reverseParentheses("(abcd)"));
		System.out.println(test.reverseParentheses("(u(love)i)"));
		System.out.println(test.reverseParentheses("(ed(et(oc))el)"));
	}

	public String reverseParentheses(String s) {
		int length = s.length();
		Stack<Integer> stack = new Stack<>();
		int[] pair = new int[length];
		for (int i = 0; i < length; i++) {
			switch (s.charAt(i)) {
				case '(':
					stack.push(i);
					break;
				case ')':
					int j = stack.pop();
					pair[i] = j;
					pair[j] = i;
					break;
				}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, direction = 1; i < length; i += direction) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				i = pair[i];
				direction = -direction;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
