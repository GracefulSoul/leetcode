package gracefulsoul.object.codec.bst;

import gracefulsoul.object.node.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		this.serialize(sb, root);
		return sb.toString();
	}

	private void serialize(StringBuilder sb, TreeNode root) {
		if (root != null) {
			sb.append((char) (root.val + '0'));
			this.serialize(sb, root.left);
			this.serialize(sb, root.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		TreeNode root = null;
		for (char c : data.toCharArray()) {
			root = this.add(root, c - '0');
		}
		return root;
	}

	private TreeNode add(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		} else {
			if (val < root.val) {
				root.left = this.add(root.left, val);
			} else {
				root.right = this.add(root.right, val);
			}
			return root;
		}
	}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
