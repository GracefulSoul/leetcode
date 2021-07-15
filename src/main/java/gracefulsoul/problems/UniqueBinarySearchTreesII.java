package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.TreeNode;

public class UniqueBinarySearchTreesII {

	// https://leetcode.com/submissions/detail/522820317/
	public static void main(String[] args) {
		UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
		print(test.generateTrees(3));

	}

	public List<TreeNode> generateTrees(int n) {
		return this.recursive(1, n);
	}

	private List<TreeNode> recursive(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
		}
		for (int idx = start; idx <= end; idx++) {
			for (TreeNode left : this.recursive(start, idx - 1)) {
				for (TreeNode right : this.recursive(idx + 1, end)) {
					result.add(new TreeNode(idx, left, right));
				}
			}
		}
		return result;
	}

	private static void print(List<TreeNode> treeNodeList) {
		for (TreeNode treeNode : treeNodeList) {
			print(treeNode, true, false);
			System.out.println();
		}
	}

	private static void print(TreeNode treeNode, boolean isRoot, boolean isLeft) {
		if (treeNode != null) {
			if (!isRoot) {
				System.out.print("(");
			}
			print(treeNode.left, false, true);
			print(treeNode.val);
			System.out.print(", ");
			print(treeNode.right, false, false);
			if (!isRoot) {
				System.out.print(")");
			}
		} else {
			print("null");
		}
		if (isLeft) {
			System.out.print(", ");
		}
	}
	
	private static void print(Object val) {
		System.out.print("(" + val + ")");
	}
	
}
