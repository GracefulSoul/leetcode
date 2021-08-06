package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.Node;

public class PopulatingNextRightPointersInEachNode {

	// https://leetcode.com/submissions/detail/534076549/
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
		print(test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null),  new Node(3, new Node(6), new Node(7), null), null)));
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
