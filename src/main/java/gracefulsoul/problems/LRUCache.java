package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.linked.Node;

public class LRUCache {

	// https://leetcode.com/submissions/detail/549118163/
	public static void main(String[] args) {
		LRUCache test = new LRUCache(2);
		test.put(1, 1); // cache is {1=1}
		test.print();
		test.put(2, 2); // cache is {1=1, 2=2}
		test.print();
		System.out.println(test.get(1)); // return 1
		test.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		test.print();
		System.out.println(test.get(2)); // returns -1 (not found)
		test.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		test.print();
		System.out.println(test.get(1)); // return -1 (not found)
		System.out.println(test.get(3)); // return 3
		System.out.println(test.get(4)); // return 4
	}

	private Map<Integer, Node> map = new HashMap<>();

	private Node head = new Node(0, 0);
	private Node tail = new Node(0, 0);

	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			Node node = this.map.get(key);
			this.remove(node);
			this.insert(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (this.map.containsKey(key)) {
			this.remove(this.map.get(key));
		}
		if (this.map.size() == this.capacity) {
			this.remove(this.tail.prev);
		}
		this.insert(new Node(key, value));
	}

	private void remove(Node node) {
		this.map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insert(Node node) {
		this.map.put(node.key, node);
		Node next = this.head.next;
		this.head.next = node;
		node.prev = this.head;
		next.prev = node;
		node.next = next;
	}

	public void print() {
		int cnt = 0;
		for (Map.Entry<Integer, Node> entry : this.map.entrySet()) {
			System.out.printf("{%d=%d}", entry.getKey(), entry.getValue().value);
			if (cnt++ < map.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
