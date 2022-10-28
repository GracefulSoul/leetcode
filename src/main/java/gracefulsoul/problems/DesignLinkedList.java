package gracefulsoul.problems;

import gracefulsoul.object.node.Node;

public class DesignLinkedList {

	// https://leetcode.com/submissions/detail/832356254/
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(1);
		myLinkedList.addAtTail(3);
		myLinkedList.addAtIndex(1, 2);				// linked list becomes 1->2->3
		System.out.println(myLinkedList.get(1));	// return 2
		myLinkedList.deleteAtIndex(1);				// now the linked list is 1->3
		System.out.println(myLinkedList.get(1));	// return 3
	}

}

class MyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList() {
		this.size = 0;
	}

	public int get(int index) {
		if (index >= this.size) {
			return -1;
		}
		Node node = this.head;
		while (index-- > 0) {
			node = node.next;
		}
		return node.val;
	}

	public void addAtHead(int val) {
		Node node = new Node(val);
		node.next = this.head;
		this.head = node;
		this.size++;
		if (this.head.next == null) {
			this.tail = this.head;
		}
	}

	public void addAtTail(int val) {
		Node node = new Node(val);
		if (this.tail != null) {
			this.tail.next = node;
		}
		if (this.tail == null || this.size == 0) {
			this.head = node;
		}
		this.tail = node;
		this.size++;
	}

	public void addAtIndex(int index, int val) {
		if (index < 0 || index > size) {
			return;
		}
		if (index == 0) {
			this.addAtHead(val);
		} else if (index == size) {
			this.addAtTail(val);
		} else {
			Node prev = this.head;
			while (index-- > 1) {
				prev = prev.next;
			}
			Node node = new Node(val);
			Node curr = prev;
			prev = prev.next;
			curr.next = node;
			node.next = prev;
			this.size++;
		}
	}

	public void deleteAtIndex(int index) {
		if (this.size == 0 || index < 0 || index >= this.size) {
			return;
		}
		if (index == 0) {
			this.head = this.head.next;
			this.size--;
			if (this.size == 0) {
				this.tail = null;
			}
		} else {
			Node prev = this.head;
			while (index-- > 1) {
				prev = prev.next;
			}
			prev.next = prev.next.next;
			this.size--;
			if (prev.next == null) {
				this.tail = prev;
			}
		}
	}

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */