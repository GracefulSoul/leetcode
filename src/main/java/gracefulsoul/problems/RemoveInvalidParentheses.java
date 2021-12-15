package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

	// https://leetcode.com/submissions/detail/602086162/
	public static void main(String[] args) {
		RemoveInvalidParentheses test = new RemoveInvalidParentheses();
		System.out.println(test.removeInvalidParentheses("()())()"));
		System.out.println(test.removeInvalidParentheses("(a)())()"));
		System.out.println(test.removeInvalidParentheses(")("));

	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		this.recursive(s, result, new char[] { '(', ')' }, 0, 0);
		return result;
	}

	private void recursive(String s, List<String> result, char[] check, int last_i, int last_j) {
		int count = 0;
		int i = last_i;
		while (i < s.length() && count >= 0) {
			if (s.charAt(i) == check[0]) {
				count++;
			}
			if (s.charAt(i) == check[1]) {
				count--;
			}
			i++;
		}
		if (count >= 0) {
			String reversed = new StringBuilder(s).reverse().toString();
			if (check[0] == '(') {
				this.recursive(reversed, result, new char[] { ')', '(' }, 0, 0);
			} else {
				result.add(reversed);
			}
		} else {
			i = i - 1;
			for (int j = last_j; j <= i; j++) {
				if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j - 1) != check[1])) {
					this.recursive(s.substring(0, j) + s.substring(j + 1, s.length()), result, check, i, j);
				}
			}
		}
	}

}
