package gracefulsoul.problems;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	// https://leetcode.com/submissions/detail/550807774/
	public static void main(String[] args) {
		EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
		System.out.println(test.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(test.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(test.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			switch (token) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					stack.push((-1) * stack.pop() + stack.pop());
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					int n1 = stack.pop(), n2 = stack.pop();
					stack.push(n2 / n1);
					break;
				default:
					stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

}
