package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

	// https://leetcode.com/submissions/detail/602098345/
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

	private void recursive(String s, List<String> result, char[] check, int x, int y) {
		int count = 0;
		int i = x;
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
			String reverse = new StringBuilder(s).reverse().toString();
			if (check[0] == '(') {
				this.recursive(reverse, result, new char[] { ')', '(' }, 0, 0);
			} else {
				result.add(reverse);
			}
		} else {
			i--;
			for (int j = y; j <= i; j++) {
				if (s.charAt(j) == check[1] && (j == y || s.charAt(j - 1) != check[1])) {
					this.recursive(s.substring(0, j) + s.substring(j + 1, s.length()), result, check, i, j);
				}
			}
		}
	}

}
