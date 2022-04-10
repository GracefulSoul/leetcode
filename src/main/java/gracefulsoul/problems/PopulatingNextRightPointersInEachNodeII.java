package gracefulsoul.problems;

import gracefulsoul.object.node.Node;
import gracefulsoul.util.PrintUtil;

public class PopulatingNextRightPointersInEachNodeII {

	// https://leetcode.com/submissions/detail/534492644/
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII test = new PopulatingNextRightPointersInEachNodeII();
		PrintUtil.print(test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null)));
	}

	public Node connect(Node root) {
		this.recursive(root, null);
		return root;
	}

	private void recursive(Node curr, Node pre) {
		if (curr == null) {
			return;
		}
		if (curr.left != null) {
			curr.left.next = curr.right;
		}
		while (curr.next == null && pre != null && pre.next != null) {
			pre = pre.next;
			curr.next = (pre.left != null) ? pre.left : pre.right;
		}
		this.recursive(curr.right, curr);
		this.recursive(curr.left, curr);
	}

}
