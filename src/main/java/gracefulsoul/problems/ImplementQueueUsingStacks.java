package gracefulsoul.problems;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	// https://leetcode.com/submissions/detail/582968569/
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek()); // return 1
		System.out.println(myQueue.pop()); // return 1, queue is [2]
		System.out.println(myQueue.empty()); // return false
	}

}

class MyQueue {

	private Stack<Integer> input;
	private Stack<Integer> output;

	public MyQueue() {
		this.input = new Stack<>();
		this.output = new Stack<>();
	}

	public void push(int x) {
		this.input.push(x);
	}

	public int pop() {
		this.move();
		return this.output.pop();
	}

	public int peek() {
		this.move();
		return this.output.peek();
	}

	public boolean empty() {
		return this.input.empty() && this.output.empty();
	}

	private void move() {
		if (this.output.empty()) {
			while (!this.input.empty()) {
				this.output.push(this.input.pop());
			}
		}
	}

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */