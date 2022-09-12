package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class PrintBinaryTree {

	// https://leetcode.com/submissions/detail/797507282/
	public static void main(String[] args) {
		PrintBinaryTree test = new PrintBinaryTree();
		System.out.println(test.printTree(new TreeNode(1, new TreeNode(2), null)));
		System.out.println(test.printTree(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3))));
	}

	public List<List<String>> printTree(TreeNode root) {
		int height = this.getHeight(root);
		List<List<String>> tree = new ArrayList<>();
		int num = (int) Math.pow(2, height) - 1;
		for (int i = 1; i <= height; i++) {
			String[] array = new String[num];
			Arrays.fill(array, "");
			tree.add(Arrays.asList(array));
		}
		this.fill(root, 0, num - 1, tree, 0);
		return tree;
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
		}
	}

	private void fill(TreeNode root, int start, int end, List<List<String>> tree, int row) {
		if (root == null) {
			return;
		}
		int mid = (start + end) / 2;
		List<String> list = tree.get(row);
		list.set(mid, String.valueOf(root.val));
		this.fill(root.left, start, mid - 1, tree, row + 1);
		this.fill(root.right, mid + 1, end, tree, row + 1);
	}

}
