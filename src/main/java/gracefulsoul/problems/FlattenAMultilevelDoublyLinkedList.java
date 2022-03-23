package gracefulsoul.problems;

import gracefulsoul.object.node.flatten.Node;

public class FlattenAMultilevelDoublyLinkedList {

	// https://leetcode.com/submissions/detail/666035942/
	public static void main(String[] args) {
		FlattenAMultilevelDoublyLinkedList test = new FlattenAMultilevelDoublyLinkedList();
		Node node1 = new Node(1);
		Node node2 = new Node(2, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(4, node3);
		Node node5 = new Node(5, node4);
		Node node6 = new Node(6, node5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		Node node7 = new Node(7);
		Node node8 = new Node(8, node7);
		Node node9 = new Node(9, node8);
		Node node10 = new Node(10, node9);
		node3.child = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		Node node11 = new Node(11);
		Node node12 = new Node(12, node11);
		node8.child = node11;
		node11.next = node12;
		print(test.flatten(node1));
		Node node13 = new Node(1);
		Node node14 = new Node(2, node13);
		Node node15 = new Node(3);
		node13.next = node14;
		node13.child = node15;
		print(test.flatten(node13));
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		} else if (head.child == null) {
			Node node = this.flatten(head.next);
			head.next = node;
			if (node != null) {
				node.prev = head;
			}
		} else {
			Node node = head.next;
			Node child = this.flatten(head.child);
			head.next = child;
			child.prev = head;
			Node temp = child;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node next = this.flatten(node);
			temp.next = next;
			if (next != null) {
				next.prev = temp;
			}
			head.child = null;
		}
		return head;
	}

	private static void print(Node node) {
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
			if (node != null) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
