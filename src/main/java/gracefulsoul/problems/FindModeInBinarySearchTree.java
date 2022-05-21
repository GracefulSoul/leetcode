package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class FindModeInBinarySearchTree {

	// https://leetcode.com/submissions/detail/704065654/
	public static void main(String[] args) {
		PrintUtil.print(new FindModeInBinarySearchTree().findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null))));
		PrintUtil.print(new FindModeInBinarySearchTree().findMode(new TreeNode(0)));
	}

	private int max = 0;
	private int count = 1;
	private TreeNode prev = null;

	public int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		this.dfs(root, list);
		int[] result = new int[list.size()];
		for (int idx = 0; idx < list.size(); idx++) {
			result[idx] = list.get(idx);
		}
		return result;
	}

	public void dfs(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		this.dfs(node.left, list);
		if (this.prev != null) {
			if (node.val == this.prev.val) {
				this.count++;
			} else {
				this.count = 1;
			}
		}
		if (this.count > this.max) {
			list.clear();
			list.add(node.val);
			this.max = this.count;
		} else if (this.count == this.max) {
			list.add(node.val);
		}
		this.prev = node;
		this.dfs(node.right, list);
	}

}
