package gracefulsoul.problems;

import java.util.Stack;

import gracefulsoul.util.PrintUtil;

public class AddingTwoNegabinaryNumbers {

	// https://leetcode.com/problems/adding-two-negabinary-numbers/submissions/1225360468/
	public static void main(String[] args) {
		AddingTwoNegabinaryNumbers test = new AddingTwoNegabinaryNumbers();
		PrintUtil.print(test.addNegabinary(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 1 }));
		PrintUtil.print(test.addNegabinary(new int[] { 0 }, new int[] { 0 }));
		PrintUtil.print(test.addNegabinary(new int[] { 0 }, new int[] { 1 }));
	}

	public int[] addNegabinary(int[] arr1, int[] arr2) {
		Stack<Integer> stack = new Stack<>();
		for (int i = arr1.length - 1, j = arr2.length - 1, k = 0; i >= 0 || j >= 0 || k != 0;) {
			if (i >= 0) {
				k += arr1[i--];
			}
			if (j >= 0) {
				k += arr2[j--];
			}
			stack.push(k & 1);
			k = -(k >> 1);
		}
		while (!stack.isEmpty() && stack.peek() == 0) {
			stack.pop();
		}
		int[] result = new int[stack.size()];
		for (int i = 0; !stack.isEmpty(); i++) {
			result[i] = stack.pop();
		}
		return result.length == 0 ? new int[1] : result;
	}

}
