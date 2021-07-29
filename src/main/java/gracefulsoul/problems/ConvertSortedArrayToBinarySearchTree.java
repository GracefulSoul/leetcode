package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	// https://leetcode.com/submissions/detail/529932117/
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
		print(test.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }), true, false);
		print(test.sortedArrayToBST(new int[] { 1, 3 }), true, false);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return this.recursive(nums, 0, nums.length - 1);
	}

	private TreeNode recursive(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode treeNode = new TreeNode(nums[mid]);
		treeNode.left = this.recursive(nums, low, mid - 1);
		treeNode.right = this.recursive(nums, mid + 1, high);
		return treeNode;
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
		if (isRoot) {
			System.out.println();
		}
	}

	private static void print(Object val) {
		System.out.print("(" + val + ")");
	}

}
