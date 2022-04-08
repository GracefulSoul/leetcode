package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreePaths {

	// https://leetcode.com/submissions/detail/589340307/
	public static void main(String[] args) {
		BinaryTreePaths test = new BinaryTreePaths();
		System.out.println(test.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
		System.out.println(test.binaryTreePaths(new TreeNode(1)));
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		this.recursive(root, result, new StringBuilder(), 0);
		return result;
	}

	public void recursive(TreeNode root, List<String> list, StringBuilder stringBuilder, int length) {
		if (root == null) {
			return;
		}
		stringBuilder.append(root.val);
		if (root.left == null && root.right == null) {
			list.add(stringBuilder.toString());
		} else {
			stringBuilder.append("->");
			this.recursive(root.left, list, stringBuilder, stringBuilder.length());
			this.recursive(root.right, list, stringBuilder, stringBuilder.length());
		}
		stringBuilder.setLength(length);
	}

}
