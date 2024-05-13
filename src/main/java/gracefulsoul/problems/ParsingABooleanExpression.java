package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParsingABooleanExpression {

	// https://leetcode.com/problems/parsing-a-boolean-expression/submissions/1256814527/
	public static void main(String[] args) {
		ParsingABooleanExpression test = new ParsingABooleanExpression();
		System.out.println(test.parseBoolExpr("&(|(f))"));
		System.out.println(test.parseBoolExpr("|(f,f,f,t)"));
		System.out.println(test.parseBoolExpr("!(&(f,t))"));
	}

	public boolean parseBoolExpr(String expression) {
		Stack<Character> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (c == ')') {
				Set<Character> seen = new HashSet<>();
				while (stack.peek() != '(') {
					seen.add(stack.pop());
				}
				stack.pop();
				switch (stack.pop()) {
					case '&': stack.push(seen.contains('f') ? 'f' : 't'); break;
					case '|': stack.push(seen.contains('t') ? 't' : 'f'); break;
					default: stack.push(seen.contains('t') ? 'f' : 't'); break;
				}
			} else if (c != ',') {
				stack.push(c);
			}
		}
		return stack.pop() == 't';
	}

}
