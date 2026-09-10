package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

	// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/submissions/2137440806/
	public static void main(String[] args) {
		CountNodesEqualToAverageOfSubtree test = new CountNodesEqualToAverageOfSubtree();
		System.out.println(test.averageOfSubtree(new TreeNode(4, new TreeNode(8, new TreeNode(), new TreeNode(1)), new TreeNode(5, null, new TreeNode(6)))));
		System.out.println(test.averageOfSubtree(new TreeNode(1)));
	}

	private int count;

	public int averageOfSubtree(TreeNode root) {
		this.count = 0;
		this.calculate(root);
		return this.count;
	}

	private int[] calculate(TreeNode curr) {
		if (curr == null) {
			return new int[] { 0, 0 };
		} else {
			int[] left = this.calculate(curr.left);
			int[] right = this.calculate(curr.right);
			int sum = left[0] + right[0] + curr.val;
			int count = left[1] + right[1] + 1;
			if (sum / count == curr.val) {
				this.count++;
			}
			return new int[] { sum, count };
		}
	}

}
