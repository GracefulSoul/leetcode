package gracefulsoul.problems;

import java.util.Random;
import java.util.Stack;

import gracefulsoul.object.node.down.Node;

public class DesignSkiplist {

	// https://leetcode.com/problems/design-skiplist/submissions/1420493685/
	public static void main(String[] args) {
		Skiplist skiplist = new Skiplist();
		skiplist.add(1);
		skiplist.add(2);
		skiplist.add(3);
		System.out.println(skiplist.search(0));	// return False
		skiplist.add(4);
		System.out.println(skiplist.search(1));	// return True
		System.out.println(skiplist.erase(0));	// return False, 0 is not in skiplist.
		System.out.println(skiplist.erase(1));	// return True
		System.out.println(skiplist.search(1));	// return False, 1 has already been erased.
	}

}

class Skiplist {

	private Node head;
	private Random random;

	public Skiplist() {
		this.head = new Node(-1, null, null);
		this.random = new Random();
	}

	public boolean search(int target) {
		Node curr = this.head;
		while (curr != null) {
			while (curr.next != null && curr.next.val < target) {
				curr = curr.next;
			}
			if (curr.next != null && curr.next.val == target) {
				return true;
			}
			curr = curr.down;
		}
		return false;
	}

	public void add(int num) {
		Stack<Node> stack = new Stack<>();
		Node curr = this.head;
		while (curr != null) {
			while (curr.next != null && curr.next.val < num) {
				curr = curr.next;
			}
			stack.push(curr);
			curr = curr.down;
		}
		boolean insert = true;
		Node down = null;
		while (insert && !stack.isEmpty()) {
			curr = stack.pop();
			curr.next = new Node(num, curr.next, down);
			down = curr.next;
			insert = this.random.nextDouble() < 0.5;
		}
		if (insert) {
			this.head = new Node(-1, null, this.head);
		}
	}

	public boolean erase(int num) {
		Node curr = this.head;
		boolean found = false;
		while (curr != null) {
			while (curr.next != null && curr.next.val < num) {
				curr = curr.next;
			}
			if (curr.next != null && curr.next.val == num) {
				found = true;
				curr.next = curr.next.next;
			}
			curr = curr.down;
		}
		return found;
	}

}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */