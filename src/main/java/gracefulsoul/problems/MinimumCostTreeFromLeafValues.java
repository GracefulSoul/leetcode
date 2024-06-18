package gracefulsoul.problems;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

	// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/submissions/1292188988/
	public static void main(String[] args) {
		MinimumCostTreeFromLeafValues test = new MinimumCostTreeFromLeafValues();
		System.out.println(test.mctFromLeafValues(new int[] { 6, 2, 4 }));
		System.out.println(test.mctFromLeafValues(new int[] { 4, 11 }));
	}

	public int mctFromLeafValues(int[] arr) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);
		for (int num : arr) {
			while (stack.peek() <= num) {
				result += stack.pop() * Math.min(stack.peek(), num);
			}
			stack.push(num);
		}
		while (stack.size() > 2) {
			result += stack.pop() * stack.peek();
		}
		return result;
	}

}
