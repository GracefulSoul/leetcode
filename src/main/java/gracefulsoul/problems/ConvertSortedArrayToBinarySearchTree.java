package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConvertSortedArrayToBinarySearchTree {

	// https://leetcode.com/submissions/detail/529938823/
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
		PrintUtil.print(test.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }), true, false);
		PrintUtil.print(test.sortedArrayToBST(new int[] { 1, 3 }), true, false);
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

}
