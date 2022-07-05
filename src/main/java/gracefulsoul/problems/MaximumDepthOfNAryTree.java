package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.object.node.children.Node;

public class MaximumDepthOfNAryTree {

	// https://leetcode.com/submissions/detail/739033165/
	public static void main(String[] args) {
		MaximumDepthOfNAryTree test = new MaximumDepthOfNAryTree();
		System.out.println(test.maxDepth(new Node(1, Arrays.asList(new Node[] { new Node(3, Arrays.asList(new Node[] { new Node(5), new Node(6) })), new Node(2), new Node(4) }))));
	}

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			int max = 0;
			for (Node children : root.children) {
				max = Math.max(max, this.maxDepth(children));
			}
			return max + 1;
		}
	}

}
