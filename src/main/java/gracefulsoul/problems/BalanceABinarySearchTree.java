package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class BalanceABinarySearchTree {

	// https://leetcode.com/problems/balance-a-binary-search-tree/submissions/1300714941/
	public static void main(String[] args) {
		BalanceABinarySearchTree test = new BalanceABinarySearchTree();
		PrintUtil.print(test.balanceBST(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))))), true, false);
		PrintUtil.print(test.balanceBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))), true, false);
	}

	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		this.sort(root, list);
		return this.getBST(list, 0, list.size() - 1);
	}

	private void sort(TreeNode root, List<TreeNode> list) {
		if (root != null) {
			this.sort(root.left, list);
			list.add(root);
			this.sort(root.right, list);
		}
	}

	private TreeNode getBST(List<TreeNode> list, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = (start + end) / 2;
			TreeNode root = list.get(mid);
			root.left = this.getBST(list, start, mid - 1);
			root.right = this.getBST(list, mid + 1, end);
			return root;
		}
	}

}
