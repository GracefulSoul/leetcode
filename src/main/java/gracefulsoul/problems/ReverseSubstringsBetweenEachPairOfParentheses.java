package gracefulsoul.problems;

public class ReverseSubstringsBetweenEachPairOfParentheses {

	// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/submissions/1317399345/
	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairOfParentheses test = new ReverseSubstringsBetweenEachPairOfParentheses();
		System.out.println(test.reverseParentheses("(abcd)"));
		System.out.println(test.reverseParentheses("(u(love)i)"));
		System.out.println(test.reverseParentheses("(ed(et(oc))el)"));
	}

	private int index;

	public String reverseParentheses(String s) {
		this.index = 0;
		return this.reverseParentheses(s.toCharArray());
	}

	private String reverseParentheses(char[] charArray) {
		StringBuilder sb = new StringBuilder();
		while (this.index < charArray.length) {
			switch (charArray[this.index]) {
				case ')': this.index++; return sb.reverse().toString();
				case '(': this.index++; sb.append(this.reverseParentheses(charArray)); break;
				default: sb.append(charArray[this.index]); this.index++; break;
			}
		}
		return sb.toString();
	}

}
