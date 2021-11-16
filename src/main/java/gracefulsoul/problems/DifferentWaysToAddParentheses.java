package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

	// https://leetcode.com/submissions/detail/588290652/
	public static void main(String[] args) {
		DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
		System.out.println(test.diffWaysToCompute("2-1-1"));
		System.out.println(test.diffWaysToCompute("2*3-4*5"));
	}

	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> result = new ArrayList<>();
		for (int idx = 0; idx < expression.length(); idx++) {
			char c = expression.charAt(idx);
			if (c == '-' || c == '+' || c == '*') {
				String first = expression.substring(0, idx);
				String second = expression.substring(idx + 1);
				List<Integer> firstResult = this.diffWaysToCompute(first);
				List<Integer> secondResult = this.diffWaysToCompute(second);
				for (int num1 : firstResult) {
					for (int num2 : secondResult) {
						switch (c) {
						case '-':
							result.add(num1 - num2);
							break;
						case '+':
							result.add(num1 + num2);
							break;
						case '*':
							result.add(num1 * num2);
							break;
						}
					}
				}
			}
		}
		if (result.isEmpty()) {
			result.add(Integer.valueOf(expression));
		}
		return result;
	}

}
