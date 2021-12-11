package gracefulsoul.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	// https://leetcode.com/submissions/detail/600184741/
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		print(deser.deserialize(
				ser.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))))),
				true, false);
		print(deser.deserialize(ser.serialize(new TreeNode())), true, false);
		print(deser.deserialize(ser.serialize(new TreeNode(1))), true, false);
		print(deser.deserialize(ser.serialize(new TreeNode(1, new TreeNode(2), null))), true, false);
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

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