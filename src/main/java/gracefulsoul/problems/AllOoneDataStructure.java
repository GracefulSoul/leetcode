package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.count.Node;

public class AllOoneDataStructure {

	// https://leetcode.com/submissions/detail/666736764/
	public static void main(String[] args) {
		AllOne allOne = new AllOne();
		allOne.inc("hello");
		allOne.inc("hello");
		System.out.println(allOne.getMaxKey()); // return "hello"
		System.out.println(allOne.getMinKey()); // return "hello"
		allOne.inc("leet");
		System.out.println(allOne.getMaxKey()); // return "hello"
		System.out.println(allOne.getMinKey()); // return "leet"
	}

}

class AllOne {

	private Node head;
	private Node tail;
	private Map<String, Node> map;

	public AllOne() {
		this.map = new HashMap<>();
	}

	public void inc(String key) {
		Node node = this.map.get(key);
		if (node == null) {
			node = new Node(key);
			this.map.put(key, node);
			if (this.head == null) {
				this.head = node;
				this.tail = node;
			} else {
				this.head.left = node;
				node.right = this.head;
				this.head = node;
			}
		} else {
			node.count++;
			while (this.tail != node && node.count > node.right.count) {
				this.swap(node, node.right);
			}
		}
	}

	public void dec(String key) {
		Node node = this.map.get(key);
		node.count--;
		if (node.count == 0) {
			this.map.remove(key);
			if (node.right != null) {
				node.right.left = node.left;
			}
			if (node.left != null) {
				node.left.right = node.right;
			}
			if (node == head) {
				this.head = node.right;
			}
			if (node == tail) {
				this.tail = node.left;
			}
		} else {
			while (this.head != node && node.count < node.left.count) {
				this.swap(node.left, node);
			}
		}
	}

	public String getMinKey() {
		return this.head == null ? "" : this.head.val; 
	}

	public String getMaxKey() {
		return this.tail == null ? "" : this.tail.val;
	}

	private void swap(Node node1, Node node2) {
		Node left = node1.left;
		Node right = node2.right;
		if (left == null) {
			this.head = node2;
		} else {
			left.right = node2;
		}
		node2.left = left;
		if (right == null) {
			this.tail = node1;
		} else {
			right.left = node1;
		}
		node1.right = right;
		node1.left = node2;
		node2.right = node1;
	}

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */