package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.random.Node;

public class CopyListWithRandomPointer {

	// https://leetcode.com/submissions/detail/544833316/
	public static void main(String[] args) {
		CopyListWithRandomPointer test = new CopyListWithRandomPointer();
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node1.random = null;
		node2.next = node3;
		node2.random = node1;
		node3.next = node4;
		node3.random = node5;
		node4.next = node5;
		node4.random = node3;
		node5.next = null;
		node5.random = node1;
		print(node1);
		System.out.println();
		print(test.copyRandomList(node1));
	}

	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		return this.recursive(head, map);
	}

	private Node recursive(Node head, Map<Node, Node> map) {
		if (head == null) {
			return null;
		} else if (map.containsKey(head)) {
			return map.get(head);
		} else {
			Node temp = new Node(head.val);
			map.put(head, temp);
			temp.next = this.recursive(head.next, map);
			temp.random = this.recursive(head.random, map);
			return temp;
		}
	}
	
	private static void print(Node node) {
		if (node != null) {
			System.out.printf("[%s,%s]", node.val, node.random == null ? "null" : node.random.val);
			print(node.next);
		}
	}

}
