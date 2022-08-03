package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class ConstructStringFromBinaryTree {

	// https://leetcode.com/submissions/detail/764093480/
	public static void main(String[] args) {
		ConstructStringFromBinaryTree test = new ConstructStringFromBinaryTree();
		System.out.println(test.tree2str(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
		System.out.println(test.tree2str(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3))));
	}

	public String tree2str(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		this.dfs(root, sb);
		return sb.toString();
	}

	private void dfs(TreeNode root, StringBuilder sb) {
		if (null != root) {
			sb.append(root.val);
			if (null != root.left) {
				sb.append('(');
				this.dfs(root.left, sb);
				sb.append(')');
			}
			if (null != root.right) {
				if (null == root.left) {
					sb.append('(').append(')');
				}
				sb.append('(');
				this.dfs(root.right, sb);
				sb.append(')');
			}
		}
	}

}
