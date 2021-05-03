package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	// https://leetcode.com/submissions/detail/488294744/
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		test.generateParenthesis(3).forEach(System.out::println);
		test.generateParenthesis(1).forEach(System.out::println);
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		this.generate(list, "", 0, 0, n);
		return list;
	}

	private void generate(List<String> list, String str, int left, int right, int n) {
		if (str.length() == n * 2) {
			list.add(str);
			return;
		}
		if (left < n) {
			this.generate(list, this.appendString(str, '('), left + 1, right, n);
		}
		if (right < left) {
			this.generate(list, this.appendString(str, ')'), left, right + 1, n);
		}
	}

	private String appendString(String str, char c) {
		return new StringBuilder(str).append(c).toString();
	}

}
