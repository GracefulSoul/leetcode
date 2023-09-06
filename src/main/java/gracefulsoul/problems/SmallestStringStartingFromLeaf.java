package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SmallestStringStartingFromLeaf {

	// https://leetcode.com/problems/smallest-string-starting-from-leaf/submissions/1041108684/
	public static void main(String[] args) {
		SmallestStringStartingFromLeaf test = new SmallestStringStartingFromLeaf();
		System.out.println(test.smallestFromLeaf(new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
		System.out.println(test.smallestFromLeaf(new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)))));
		System.out.println(test.smallestFromLeaf(new TreeNode(2, new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)), new TreeNode(1, new TreeNode(0), null))));
	}

	private String str;

	public String smallestFromLeaf(TreeNode root) {
		this.str = null;
		this.dfs(root, new StringBuilder());
		return this.str;
	}

	public void dfs(TreeNode root, StringBuilder sb) {
		if (root != null) {
			char c = (char) (root.val + 97);
			sb.append(c);
			if (root.left == null && root.right == null) {
				String s = sb.reverse().toString();
				if (this.str == null || this.str.compareTo(s) > 0) {
					this.str = s;
				}
				sb.reverse();
			}
			this.dfs(root.left, sb);
			this.dfs(root.right, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
