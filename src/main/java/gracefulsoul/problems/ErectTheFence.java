package gracefulsoul.problems;

import java.util.Arrays;

public class ErectTheFence {

	// https://leetcode.com/submissions/detail/751034564/
	public static void main(String[] args) {
		ErectTheFence test = new ErectTheFence();
		System.out.println(test.outerTrees(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 2, 0 },
			{ 2, 4 },
			{ 3, 3 },
			{ 4, 2 }
		}));
		System.out.println(test.outerTrees(new int[][] {
			{ 1, 2 },
			{ 2, 2 },
			{ 4, 2 }
		}));
	}

	public int[][] outerTrees(int[][] trees) {
		Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int length = trees.length;
		int top = 0;
		boolean[] used = new boolean[length];
		int[] dp = new int[length + 2];
		for (int idx = 0; idx < length; idx++) {
			while (top >= 2 && this.area(trees[dp[top - 1]], trees[dp[top]], trees[idx]) > 0) {
				used[dp[top--]] = false;
			}
			used[idx] = true;
			dp[++top] = idx;
		}
		used[0] = false;
		for (int idx = length - 1; idx >= 0; idx--) {
			if (used[idx]) {
				continue;
			}
			while (top >= 2 && this.area(trees[dp[top - 1]], trees[dp[top]], trees[idx]) > 0) {
				top--;
			}
			dp[++top] = idx;
		}
		top--;
		int[][] result = new int[top][2];
		for (int idx = 0; idx < top; idx++) {
			result[idx] = trees[dp[idx + 1]];
		}
		return result;
	}

	private int area(int[] b, int[] c, int[] a) {
		return this.cross(b[0] - a[0], b[1] - a[1], c[0] - a[0], c[1] - a[1]);
	}

	private int cross(int x1, int y1, int x2, int y2) {
		return x1 * y2 - x2 * y1;
	}

}
