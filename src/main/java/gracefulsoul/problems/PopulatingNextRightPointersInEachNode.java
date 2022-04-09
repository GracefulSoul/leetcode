package gracefulsoul.problems;

import gracefulsoul.object.node.Node;
import gracefulsoul.util.PrintUtil;

public class PopulatingNextRightPointersInEachNode {

	// https://leetcode.com/submissions/detail/534076549/
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
		PrintUtil.print(test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null),  new Node(3, new Node(6), new Node(7), null), null)));
	}

	public Node connect(Node root) {
		this.recursive(root, null);
		return root;
	}

	private void recursive(Node curr, Node next) {
		if (curr == null) {
			return;
		}
		curr.next = next;
		this.recursive(curr.left, curr.right);
		this.recursive(curr.right, curr.next == null ? null : curr.next.left);
	}

}
