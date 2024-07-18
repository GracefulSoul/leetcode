package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class NumberOfGoodLeafNodesPairs {

	// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/submissions/1325037253/
	public static void main(String[] args) {
		NumberOfGoodLeafNodesPairs test = new NumberOfGoodLeafNodesPairs();
		System.out.println(test.countPairs(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)), 3));
		System.out.println(test.countPairs(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), 3));
	}

	private int result;

	public int countPairs(TreeNode root, int distance) {
		this.result = 0;
		this.dfs(root, distance);
		return this.result;
	}

	private int[] dfs(TreeNode root, int distance) {
		if (root == null) {
			return new int[distance + 1];
		} else if (root.left == null && root.right == null) {
			int[] result = new int[distance + 1];
			result[1]++;
			return result;
		} else {
			int[] left = this.dfs(root.left, distance);
			int[] right = this.dfs(root.right, distance);
			for (int i = 1; i < left.length; i++) {
				for (int j = distance - 1; j >= 0; j--) {
					if (i + j <= distance) {
						this.result += left[i] * right[j];
					}
				}
			}
			int[] result = new int[distance + 1];
			for (int i = result.length - 2; i >= 1; i--) {
				result[i + 1] = left[i] + right[i];
			}

			return result;
		}
	}

}
