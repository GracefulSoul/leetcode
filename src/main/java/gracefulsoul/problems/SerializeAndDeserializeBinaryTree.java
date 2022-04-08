package gracefulsoul.problems;

import gracefulsoul.object.codec.bt.Codec;
import gracefulsoul.object.node.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	// https://leetcode.com/submissions/detail/600184741/
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		print(deser.deserialize(ser.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))))), true, false);
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
