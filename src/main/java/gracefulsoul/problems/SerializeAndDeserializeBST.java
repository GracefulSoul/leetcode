package gracefulsoul.problems;

import gracefulsoul.object.codec.bst.Codec;
import gracefulsoul.object.node.TreeNode;

public class SerializeAndDeserializeBST {

	// https://leetcode.com/submissions/detail/676073207/
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		String tree = ser.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
		System.out.println(tree);
		print(deser.deserialize(tree), true, false);
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
