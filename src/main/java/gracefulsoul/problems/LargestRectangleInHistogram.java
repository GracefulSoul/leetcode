package gracefulsoul.problems;

import java.util.Stack;

public class LargestRectangleInHistogram {

	// https://leetcode.com/submissions/detail/517137461/
	public static void main(String[] args) {
		LargestRectangleInHistogram test = new LargestRectangleInHistogram();
		System.out.println(test.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
		System.out.println(test.largestRectangleArea(new int[] { 2, 4 }));
	}

	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int idx = 0; idx < heights.length; idx++) {
			maxArea = this.getMaxArea(heights, stack, maxArea, idx);
			stack.push(idx);
		}
		return this.getMaxArea(heights, stack, maxArea, heights.length);
	}
	
	private int getMaxArea(int[] heights, Stack<Integer> stack, int maxArea, int idx) {
		int _maxArea = maxArea;
		while (!stack.isEmpty() && (idx == heights.length || heights[idx] < heights[stack.peek()])) {
			int height = heights[stack.pop()];
			int start = stack.isEmpty() ? -1 : stack.peek();
			_maxArea = Math.max(_maxArea, height * (idx - start - 1));
		}
		return _maxArea;
	}
	
}
