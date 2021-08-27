package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.Node;

public class PopulatingNextRightPointersInEachNodeII {

	// https://leetcode.com/submissions/detail/534492644/
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII test = new PopulatingNextRightPointersInEachNodeII();
		print(test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null)));
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

	private static void print(Node node) {
		List<Object> list = new ArrayList<>();
		getConnectedNodeValues(node, node, list);
		System.out.println(list);
	}

	private static void getConnectedNodeValues(Node start, Node temp, List<Object> list) {
		if (temp == null) {
			return;
		}
		list.add(temp.val);
		if (temp.next == null) {
			list.add("#");
			getConnectedNodeValues(start.left, start.left, list);
		} else {
			getConnectedNodeValues(start, temp.next, list);
		}
	}

}
