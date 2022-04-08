package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class MinimumDepthOfBinaryTree {

	// https://leetcode.com/submissions/detail/531329595/
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
		System.out.println(test.minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.minDepth(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<TreeNode> queue = new ArrayList<>();
		queue.add(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int idx = 0; idx < queueSize; idx++) {
				TreeNode treeNode = queue.remove(0);
				if (treeNode.left == null && treeNode.right == null) {
					return depth;
				}
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			depth++;
		}
		return depth;
	}

}
