package gracefulsoul.problems;

import java.util.Stack;

public class MaximalRectangle {

	// https://leetcode.com/submissions/detail/517550977/
	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		System.out.println(test.maximalRectangle(new char[][] {
			new char[] { '1', '0', '1', '0', '0' },
			new char[] { '1', '0', '1', '1', '1' },
			new char[] { '1', '1', '1', '1', '1' },
			new char[] { '1', '0', '0', '1', '0' }
		}));
		System.out.println(test.maximalRectangle(new char[][] {
		}));
		System.out.println(test.maximalRectangle(new char[][] {
			new char[] {'0'}
		}));
		System.out.println(test.maximalRectangle(new char[][] {
			new char[] {'1'}
		}));
		System.out.println(test.maximalRectangle(new char[][] {
			new char[] {'0', '0'}
		}));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] heights = new int[matrix[0].length];
		for (char[] row : matrix) {
			for (int i = 0; i < row.length; i++) {
				if (row[i] == '1') {
					heights[i]++;
				} else {
					heights[i] = 0;
                }
			}
			maxArea = Math.max(maxArea, this.getMaxArea(heights, new Stack<>()));
		}
		return maxArea;
	}

	public int getMaxArea(int[] heights, Stack<Integer> stack) {
		int maxArea = 0;
		for (int idx = 0; idx <= heights.length; idx++) {
			while (!stack.isEmpty() && (idx == heights.length || heights[stack.peek()] > heights[idx])) {
				int index = stack.pop();
				int start = stack.isEmpty() ? -1 : stack.peek();
				maxArea = Math.max(maxArea, heights[index] * (idx - start - 1));
			}
			stack.push(idx);
		}
		return maxArea;
	}

}
