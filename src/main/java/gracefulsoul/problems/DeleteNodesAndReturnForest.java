package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class DeleteNodesAndReturnForest {

	// https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/1264812346/
	public static void main(String[] args) {
		DeleteNodesAndReturnForest test = new DeleteNodesAndReturnForest();
		PrintUtil.print(test.delNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), new int[] { 3, 5 }));
		PrintUtil.print(test.delNodes(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4)), new int[] { 3 }));
	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<>();
		for (int value : to_delete) {
			set.add(value);
		}
		List<TreeNode> list = new ArrayList<>();
		if (!set.contains(root.val)) {
			list.add(root);
		}
		this.dfs(root, set, list);
		return list;
	}

	private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> list) {
		if (node == null) {
			return null;
		}
		node.left = this.dfs(node.left, set, list);
		node.right = this.dfs(node.right, set, list);
		if (set.contains(node.val)) {
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}
			return null;
		}
		return node;
	}

}
