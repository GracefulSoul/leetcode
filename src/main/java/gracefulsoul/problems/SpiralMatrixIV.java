package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class SpiralMatrixIV {

	// https://leetcode.com/problems/spiral-matrix-iv/submissions/1384195866/
	public static void main(String[] args) {
		SpiralMatrixIV test = new SpiralMatrixIV();
		PrintUtil.print(test.spiralMatrix(3, 5, new ListNode(3, new ListNode(0,
				new ListNode(2, new ListNode(6, new ListNode(8, new ListNode(1, new ListNode(7, new ListNode(9,
						new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(5, new ListNode(0)))))))))))))));
		PrintUtil.print(test.spiralMatrix(1, 4, new ListNode(0, new ListNode(1, new ListNode(2)))));
	}

	public int[][] spiralMatrix(int m, int n, ListNode head) {
		int[][] result = new int[m][n];
		for (int[] row : result) {
			Arrays.fill(row, -1);
		}
		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n - 1;
		while (head != null) {
			for (int col = left; col <= right && head != null; col++) {
				result[top][col] = head.val;
				head = head.next;
			}
			top++;
			for (int row = top; row <= bottom && head != null; row++) {
				result[row][right] = head.val;
				head = head.next;
			}
			right--;
			for (int col = right; col >= left && head != null; col--) {
				result[bottom][col] = head.val;
				head = head.next;
			}
			bottom--;
			for (int row = bottom; row >= top && head != null; row--) {
				result[row][left] = head.val;
				head = head.next;
			}
			left++;
		}
		return result;
	}

}
