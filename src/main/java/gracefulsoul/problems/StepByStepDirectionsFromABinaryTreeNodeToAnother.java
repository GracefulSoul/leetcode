package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

	// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/submissions/1322757909/
	public static void main(String[] args) {
		StepByStepDirectionsFromABinaryTreeNodeToAnother test = new StepByStepDirectionsFromABinaryTreeNodeToAnother();
		System.out.println(test.getDirections(new TreeNode(5, new TreeNode(1, new TreeNode(3), null), new TreeNode(2, new TreeNode(6), new TreeNode(4))), 3, 6));
		System.out.println(test.getDirections(new TreeNode(2, new TreeNode(1), null), 2, 1));
	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder start = new StringBuilder();
		StringBuilder dest = new StringBuilder();
		this.findPaths(root, startValue, start);
		this.findPaths(root, destValue, dest);
		int count = 0;
		for (int i = start.length(), j = dest.length(); i > 0 && j > 0 && start.charAt(i - 1) == dest.charAt(j - 1); i--, j--) {
			count++;
		}
		return "U".repeat(start.length() - count) + dest.reverse().substring(count).toString();
	}

	private boolean findPaths(TreeNode node, int value, StringBuilder sb) {
		if (node.val == value) {
			return true;
		} else if (node.left != null && this.findPaths(node.left, value, sb)) {
			sb.append("L");
		} else if (node.right != null && this.findPaths(node.right, value, sb)) {
			sb.append("R");
		}
		return sb.length() > 0;
	}

}
