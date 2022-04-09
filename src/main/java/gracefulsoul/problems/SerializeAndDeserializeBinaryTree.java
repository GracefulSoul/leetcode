package gracefulsoul.problems;

import gracefulsoul.object.codec.bt.Codec;
import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class SerializeAndDeserializeBinaryTree {

	// https://leetcode.com/submissions/detail/600184741/
	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();
		PrintUtil.print(deser.deserialize(ser.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))))), true, false);
		PrintUtil.print(deser.deserialize(ser.serialize(new TreeNode())), true, false);
		PrintUtil.print(deser.deserialize(ser.serialize(new TreeNode(1))), true, false);
		PrintUtil.print(deser.deserialize(ser.serialize(new TreeNode(1, new TreeNode(2), null))), true, false);
	}

}
