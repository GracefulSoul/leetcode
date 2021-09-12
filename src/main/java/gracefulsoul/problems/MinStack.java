package gracefulsoul.problems;

import gracefulsoul.object.node.min.Node;

public class MinStack {

	// https://leetcode.com/submissions/detail/553383633/
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top(); // return 0
		minStack.getMin(); // return -2
	}

	private Node node;

	/** initialize your data structure here. */
	public MinStack() {
	}

	public void push(int val) {
		if (node == null) {
			node = new Node(val, val, null);
		} else {
			node = new Node(val, Math.min(val, node.min), node); 
		}
	}

	public void pop() {
		node = node.prev;
	}

	public int top() {
		return this.node.val;
	}

	public int getMin() {
		return this.node.min;
	}

}
