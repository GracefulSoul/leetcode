package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class BinarySearchTreeToGreaterSumTree {

	// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/submissions/1170292312/
	public static void main(String[] args) {
		BinarySearchTreeToGreaterSumTree test = new BinarySearchTreeToGreaterSumTree();
		PrintUtil.print(test.bstToGst(new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))))), true, false);
		PrintUtil.print(new TreeNode(0, null, new TreeNode(1)), true, false);
	}

	public TreeNode bstToGst(TreeNode root) {
		this.bstToGst(root, new TreeNode(0));
		return root;
	}

	private void bstToGst(TreeNode node, TreeNode sum) {
		if (node == null) {
			return;
		}
		this.bstToGst(node.right, sum);
		sum.val += node.val;
		node.val = sum.val;
		this.bstToGst(node.left, sum);
	}

}
