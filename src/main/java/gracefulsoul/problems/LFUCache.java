package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.key.Node;

public class LFUCache {

	// https://leetcode.com/submissions/detail/683310554/
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);   					// cache=[1,_], cnt(1)=1
		lfu.put(2, 2);   					// cache=[2,1], cnt(2)=1, cnt(1)=1
		System.out.println(lfu.get(1));     // return 1
		                 					// cache=[1,2], cnt(2)=1, cnt(1)=2
		lfu.put(3, 3);   					// 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
		                 					// cache=[3,1], cnt(3)=1, cnt(1)=2
		System.out.println(lfu.get(2));     // return -1 (not found)
		System.out.println(lfu.get(3));     // return 3
		                 					// cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4);   					// Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
		                 					// cache=[4,3], cnt(4)=1, cnt(3)=2
		System.out.println(lfu.get(1));     // return -1 (not found)
		System.out.println(lfu.get(3));     // return 3
		                 					// cache=[3,4], cnt(4)=1, cnt(3)=3
		System.out.println(lfu.get(4));     // return 4
		                 					// cache=[4,3], cnt(4)=2, cnt(3)=3
	}

	private Node head;
	private Node tail;

	private Map<Integer, Node> map;
	private Map<Integer, Node> frequency;
	private int capacity;

	public LFUCache(int capacity) {
		this.head = new Node(-1, -1, -1);
		this.tail = new Node(-1, -1, -1);
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.map = new HashMap<>();
		this.frequency = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			Node node = map.get(key);
			this.update(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (this.capacity == 0) {
			return;
		} else if (this.map.containsKey(key)) {
			Node node = this.map.get(key);
			node.val = value;
			this.update(node);
		} else {
			Node node = new Node(key, value);
			if (this.map.size() == this.capacity) {
				Node temp = this.head.next;
				this.remove(temp);
				this.map.remove(temp.key);
			}
			this.map.put(key, node);
			this.insert(this.frequency.getOrDefault(1, this.head), node);
		}
	}

	private void update(Node node) {
		Node temp;
		if (this.frequency.containsKey(node.count + 1)) {
			temp = this.frequency.get(node.count + 1);
		} else {
			temp = this.frequency.get(node.count);
			if (temp == node) {
				temp = temp.prev;
			}
		}
		this.remove(node);
		node.count++;
		this.insert(temp, node);
	}

	private void remove(Node node) {
		if (node.prev.count != node.count && node.count != node.next.count) {
			this.frequency.remove(node.count);
		} else if (node == frequency.get(node.count)) {
			this.frequency.put(node.count, node.prev);
		}
		Node next = node.next;
		Node prev = node.prev;
		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;
	}

	private void insert(Node prev, Node curr) {
		Node next = prev.next;
		next.prev = curr;
		curr.next = next;
		curr.prev = prev;
		prev.next = curr;
		this.frequency.put(curr.count, curr);
	}

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */