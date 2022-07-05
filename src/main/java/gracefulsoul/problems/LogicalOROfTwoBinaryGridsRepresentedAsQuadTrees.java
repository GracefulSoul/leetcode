package gracefulsoul.problems;

import gracefulsoul.object.node.quad.Node;
import gracefulsoul.util.PrintUtil;

public class LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees {

	// https://leetcode.com/submissions/detail/739028533/
	public static void main(String[] args) {
		LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees test = new LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees();
		PrintUtil.print(test.intersect(new Node(true, false, new Node(true, true), new Node(true, true), new Node(false, true), new Node(false, true)), new Node(true, false, new Node(true, true), new Node(true, false, new Node(false, true), new Node(false, true), new Node(true, true), new Node(true, true)), new Node(true, true), new Node(false, true))));
		System.out.println();
		PrintUtil.print(test.intersect(new Node(false, true), new Node(false, true)));
	}

	public Node intersect(Node quadTree1, Node quadTree2) {
		if (quadTree1.isLeaf) {
			return quadTree1.val ? quadTree1 : quadTree2;
		}
		if (quadTree2.isLeaf) {
			return quadTree2.val ? quadTree2 : quadTree1;
		}
		quadTree1.topLeft = this.intersect(quadTree1.topLeft, quadTree2.topLeft);
		quadTree1.topRight = this.intersect(quadTree1.topRight, quadTree2.topRight);
		quadTree1.bottomLeft = this.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
		quadTree1.bottomRight = this.intersect(quadTree1.bottomRight, quadTree2.bottomRight);
		if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomLeft.isLeaf
				&& quadTree1.bottomRight.isLeaf && quadTree1.topLeft.val == quadTree1.topRight.val
				&& quadTree1.topRight.val == quadTree1.bottomLeft.val
				&& quadTree1.bottomLeft.val == quadTree1.bottomRight.val) {
			quadTree1.isLeaf = true;
			quadTree1.val = quadTree1.topLeft.val;
			quadTree1.topLeft = null;
			quadTree1.topRight = null;
			quadTree1.bottomLeft = null;
			quadTree1.bottomRight = null;

		}
		return quadTree1;
	}

}
