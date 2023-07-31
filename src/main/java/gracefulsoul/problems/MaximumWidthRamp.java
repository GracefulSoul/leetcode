package gracefulsoul.problems;

import java.util.Stack;

public class MaximumWidthRamp {

	// https://leetcode.com/problems/maximum-width-ramp/submissions/1008386806/
	public static void main(String[] args) {
		MaximumWidthRamp test = new MaximumWidthRamp();
		System.out.println(test.maxWidthRamp(new int[] { 6, 0, 8, 2, 1, 5 }));
		System.out.println(test.maxWidthRamp(new int[] { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 }));
	}

	public int maxWidthRamp(int[] nums) {
		int length = nums.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			if (stack.empty() || nums[i] < nums[stack.peek()]) {
				stack.push(i);
			}
		}
		int result = 0;
		for (int i = length - 1; i >= 0; i--) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
				result = Math.max(i - stack.pop(), result);
			}
		}
		return result;
	}

}
