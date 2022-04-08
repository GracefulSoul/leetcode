package gracefulsoul.object.codec.bt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
		return this.serialize(root, new StringBuilder()).toString();
	}

	private StringBuilder serialize(TreeNode root, StringBuilder stringBuilder) {
		if (root == null) {
			return stringBuilder.append(".");
		}
		stringBuilder.append(root.val).append(",");
		this.serialize(root.left, stringBuilder);
		stringBuilder.append(",");
		this.serialize(root.right, stringBuilder);
		return stringBuilder;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return this.deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	private TreeNode deserialize(Queue<String> queue) {
		String val = queue.poll();
		if (".".equals(val)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = this.deserialize(queue);
		root.right = this.deserialize(queue);
		return root;
	}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
