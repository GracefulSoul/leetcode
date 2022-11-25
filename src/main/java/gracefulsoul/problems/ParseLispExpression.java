package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {

	// https://leetcode.com/submissions/detail/849544380/
	public static void main(String[] args) {
		ParseLispExpression test = new ParseLispExpression();
		System.out.println(test.evaluate("(let x 3 x 2 x)"));
		System.out.println(test.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
	}

	public int evaluate(String expression) {
		return this.eval(expression, new HashMap<>());
	}

	private int eval(String expression, Map<String, Integer> map) {
		if (this.isNumber(expression)) {
			return Integer.valueOf(expression);
		}
		if (this.isVariable(expression)) {
			return map.get(expression);
		}
		List<String> exp = this.parse(expression);
		int result = 0;
		if (exp.get(0).equals("mult")) {
			result = this.eval(exp.get(1), map) * this.eval(exp.get(2), map);
		} else if (exp.get(0).equals("add")) {
			result = this.eval(exp.get(1), map) + this.eval(exp.get(2), map);
		} else {
			Map<String, Integer> intMap = new HashMap<>(map);
			for (int idx = 1; idx < exp.size() - 1; idx += 2) {
				intMap.put(exp.get(idx), eval(exp.get(idx + 1), intMap));
			}
			result = this.eval(exp.get(exp.size() - 1), intMap);
		}
		return result;
	}

	private boolean isNumber(String exp) {
		char c = exp.charAt(0);
		if (Character.isDigit(c) || c == '-') {
			return true;
		} else {
			return false;
		}
	}

	private boolean isVariable(String exp) {
		char c = exp.charAt(0);
		return c >= 'a' && c <= 'z';
	}

	private List<String> parse(String expression) {
		List<String> result = new ArrayList<>();
		expression = expression.substring(1, expression.length() - 1);
		int i = 0;
		while (i < expression.length()) {
			int j = i + 1;
			if (expression.charAt(i) == '(') {
				int count = 1;
				while (j < expression.length() && count > 0) {
					if (expression.charAt(j) == '(') {
						count++;
					} else if (expression.charAt(j) == ')') {
						count--;
					}
					j++;
				}
			} else {
				while (j < expression.length() && expression.charAt(j) != ' ') {
					j++;
				}
			}
			result.add(expression.substring(i, j));
			i = j + 1;
		}
		return result;
	}

}
