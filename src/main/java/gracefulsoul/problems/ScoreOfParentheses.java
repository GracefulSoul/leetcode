package gracefulsoul.problems;

import java.util.Stack;

public class ScoreOfParentheses {

	// https://leetcode.com/problems/score-of-parentheses/submissions/906865525/
	public static void main(String[] args) {
		ScoreOfParentheses test = new ScoreOfParentheses();
		System.out.println(test.scoreOfParentheses("()"));
		System.out.println(test.scoreOfParentheses("(())"));
		System.out.println(test.scoreOfParentheses("()()"));
	}

	public int scoreOfParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(result);
				result = 0;
			} else {
				result = stack.pop() + Math.max(2 * result, 1);
			}
		}
		return result;
	}
    
}
