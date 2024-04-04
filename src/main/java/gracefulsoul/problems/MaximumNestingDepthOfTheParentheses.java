package gracefulsoul.problems;

public class MaximumNestingDepthOfTheParentheses {

	// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/submissions/1222925951/
	public static void main(String[] args) {
		MaximumNestingDepthOfTheParentheses test = new MaximumNestingDepthOfTheParentheses();
		System.out.println(test.maxDepth("(1+(2*3)+((8)/4))+1"));
		System.out.println(test.maxDepth("(1)+((2))+(((3)))"));
	}

	public int maxDepth(String s) {
		int count = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '(': result = Math.max(result, ++count); break;
				case ')': count--; break;
				default:
			}
		}
		return result;
	}

}
