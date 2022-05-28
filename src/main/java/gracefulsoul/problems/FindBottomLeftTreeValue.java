package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class FindBottomLeftTreeValue {

	// https://leetcode.com/submissions/detail/709296708/
	public static void main(String[] args) {
		FindBottomLeftTreeValue test = new FindBottomLeftTreeValue();
		System.out.println(test.findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
		System.out.println(test.findBottomLeftValue(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)))));
	}

	public int findBottomLeftValue(TreeNode root) {
		return this.dfs(root, 1, new int[] { 0, 0 });
	}

	private int dfs(TreeNode root, int depth, int[] result) {
		if (result[1] < depth) {
			result[0] = root.val;
			result[1] = depth;
		}
		if (root.left != null) {
			this.dfs(root.left, depth + 1, result);
		}
		if (root.right != null) {
			this.dfs(root.right, depth + 1, result);
		}
		return result[0];
	}

}
