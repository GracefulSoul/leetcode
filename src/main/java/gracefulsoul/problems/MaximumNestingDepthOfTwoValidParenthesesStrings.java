package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {

	// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/submissions/1267093088/
	public static void main(String[] args) {
		MaximumNestingDepthOfTwoValidParenthesesStrings test = new MaximumNestingDepthOfTwoValidParenthesesStrings();
		PrintUtil.print(test.maxDepthAfterSplit("(()())"));
		PrintUtil.print(test.maxDepthAfterSplit("()(())()"));
	}

	public int[] maxDepthAfterSplit(String seq) {
		int length = seq.length();
		int[] result = new int[length];
		for (int i = 0, count = 0; i < length; i++) {
			if (seq.charAt(i) == '(') {
				result[i] = ++count % 2;
			} else {
				result[i] = count-- % 2;
			}
		}
		return result;
	}

}
