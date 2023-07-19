package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class FlipEquivalentBinaryTrees {

	// https://leetcode.com/problems/flip-equivalent-binary-trees/submissions/
	public static void main(String[] args) {
		FlipEquivalentBinaryTrees test = new FlipEquivalentBinaryTrees();
		System.out.println(test.flipEquiv(
				new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))),
						new TreeNode(3, new TreeNode(6), null)),
				new TreeNode(1, new TreeNode(3, null, new TreeNode(6)),
						new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7))))));
		System.out.println(test.flipEquiv(new TreeNode(), new TreeNode()));
		System.out.println(test.flipEquiv(new TreeNode(), new TreeNode(1)));
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null || root1.val != root2.val) {
			return false;
		} else if ((root1.left != null ? root1.left.val : -1) != (root2.left != null ? root2.left.val : -1)) {
			TreeNode temp = root1.left;
			root1.left = root1.right;
			root1.right = temp;
		}
		return this.flipEquiv(root1.left, root2.left) && this.flipEquiv(root1.right, root2.right);
	}

}
