package gracefulsoul.problems;

import gracefulsoul.object.codec.bst.Codec;
import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class SerializeAndDeserializeBST {

	// https://leetcode.com/submissions/detail/676073207/
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		String tree = ser.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
		System.out.println(tree);
		PrintUtil.print(deser.deserialize(tree), true, false);
	}

}
