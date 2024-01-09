package gracefulsoul.problems;

public class RemoveOutermostParentheses {

	// https://leetcode.com/problems/remove-outermost-parentheses/submissions/1141005790/
	public static void main(String[] args) {
		RemoveOutermostParentheses test = new RemoveOutermostParentheses();
		System.out.println(test.removeOuterParentheses("(()())(())"));
		System.out.println(test.removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(test.removeOuterParentheses("()()"));
	}

	public String removeOuterParentheses(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (char c : s.toCharArray()) {
			if ((c == '(' && count++ > 0) || (c == ')' && count-- > 1)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
