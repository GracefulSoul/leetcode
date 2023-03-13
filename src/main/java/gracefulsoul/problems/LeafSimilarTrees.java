package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class LeafSimilarTrees {

	// https://leetcode.com/problems/leaf-similar-trees/submissions/914341388/
	public static void main(String[] args) {
		LeafSimilarTrees test = new LeafSimilarTrees();
		System.out.println(test.leafSimilar(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8))),
				new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))))));
		System.out.println(test.leafSimilar(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(3), new TreeNode(2))));
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		this.dfs(root1, list1);
		this.dfs(root2, list2);
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}

	private void dfs(TreeNode root, List<Integer> list) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				list.add(root.val);
			} else {
				this.dfs(root.left, list);
				this.dfs(root.right, list);
			}
		}
	}

}
