package gracefulsoul.problems;

import java.util.Stack;

public class ValidateStackSequences {

	// https://leetcode.com/problems/validate-stack-sequences/submissions/993364785/
	public static void main(String[] args) {
		ValidateStackSequences test = new ValidateStackSequences();
		System.out.println(test.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
		System.out.println(test.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }));
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		for (int value : pushed) {
			stack.push(value);
			while (!stack.isEmpty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.isEmpty();
	}

}
