package gracefulsoul.problems;

import java.util.Stack;

public class BasicCalculator {

	// https://leetcode.com/submissions/detail/579285282/
	public static void main(String[] args) {
		BasicCalculator test = new BasicCalculator();
		System.out.println(test.calculate("1 + 1"));
		System.out.println(test.calculate(" 2-1 + 2 "));
		System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public int calculate(String s) {
		int result = 0;
		int length = s.length();
		int sign = 1;
		Stack<Integer> stack = new Stack<>();
		for (int idx = 0; idx < length; idx++) {
			char c = s.charAt(idx);
			switch (c) {
				case ' ':
					break;
				case '+':
					sign = 1;
					break;
				case '-':
					sign = -1;
					break;
				case '(':
					stack.push(result);
					stack.push(sign);
					result = 0;
					sign = 1;
					break;
				case ')':
					result = result * stack.pop() + stack.pop();
					break;
				default:
					int sum = c - '0';
					while (idx + 1 < length && Character.isDigit(s.charAt(idx + 1))) {
						sum = sum * 10 + s.charAt(idx + 1) - '0';
						idx++;
					}
					result += sum * sign;
			}
		}
		return result;
	}

}
