package gracefulsoul.problems;

import gracefulsoul.object.node.quad.Node;

public class ConstructQuadTree {

	// https://leetcode.com/submissions/detail/664761906/
	public static void main(String[] args) {
		ConstructQuadTree test = new ConstructQuadTree();
		print(test.construct(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println();
		print(test.construct(new int[][] {
			{ 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 0, 0, 0, 0 }
		}));
	}

	public Node construct(int[][] grid) {
		return this.recursive(grid, 0, grid.length - 1, 0, grid[0].length - 1);
	}

	private Node recursive(int[][] grid, int left, int right, int top, int bottom) {
		if ((left == right && top == bottom) || this.areSameValues(grid, left, right, top, bottom)) {
			return new Node(grid[left][top] == 0 ? false : true, true);
		}
		int rowMid = (left + right) / 2;
		int colMid = (top + bottom) / 2;
		return new Node(false, false,
				this.recursive(grid, left, rowMid, top, colMid),
				this.recursive(grid, left, rowMid, colMid + 1, bottom),
				this.recursive(grid, rowMid + 1, right, top, colMid),
				this.recursive(grid, rowMid + 1, right, colMid + 1, bottom));
	}

	private boolean areSameValues(int[][] grid, int left, int right, int top, int bottom) {
		int value = grid[left][top];
		for (int i = left; i <= right; i++) {
			for (int j = top; j <= bottom; j++) {
				if (grid[i][j] != value) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print(Node node) {
		if (node != null) {
			System.out.print("[" + (node.isLeaf ? 1 : 0) + ", " + (node.val ? 1 : 0) + "]");
			print(node.topLeft);
			print(node.topRight);
			print(node.bottomLeft);
			print(node.bottomRight);
		}
	}

}
