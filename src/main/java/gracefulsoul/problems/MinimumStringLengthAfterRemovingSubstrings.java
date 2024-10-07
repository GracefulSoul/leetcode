package gracefulsoul.problems;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

	// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1414594298/
	public static void main(String[] args) {
		MinimumStringLengthAfterRemovingSubstrings test = new MinimumStringLengthAfterRemovingSubstrings();
		System.out.println(test.minLength("ABFCACDB"));
		System.out.println(test.minLength("ACBBD"));
	}

	public int minLength(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C'))) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size();
	}

}
