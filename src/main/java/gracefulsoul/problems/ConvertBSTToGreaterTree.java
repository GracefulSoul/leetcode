package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConvertBSTToGreaterTree {

	// https://leetcode.com/submissions/detail/726648870/
	public static void main(String[] args) {
		PrintUtil.print(new ConvertBSTToGreaterTree().convertBST(new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))))), true, false);
		PrintUtil.print(new ConvertBSTToGreaterTree().convertBST(new TreeNode(0, null, new TreeNode(1))), true, false);
	}

	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			this.convertBST(root.right);
			sum += root.val;
			root.val = sum;
			this.convertBST(root.left);
			return root;
		}
	}

}
