package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.TreeNode;

public class BinaryTreeRightSideView {

	// https://leetcode.com/submissions/detail/564910112/
	public static void main(String[] args) {
		BinaryTreeRightSideView test = new BinaryTreeRightSideView();
		System.out.println(test.rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));
		System.out.println(test.rightSideView(new TreeNode(1, null, new TreeNode(3))));
		System.out.println(test.rightSideView(null));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		this.recursive(result, root, 0);
		return result;
	}

	private void recursive(List<Integer> list, TreeNode treeNode, int level) {
		if (treeNode == null) {
			return;
		}
		if (list.size() == level) {
			list.add(treeNode.val);
		}
		this.recursive(list, treeNode.right, level + 1);
		this.recursive(list, treeNode.left, level + 1);
	}

}
