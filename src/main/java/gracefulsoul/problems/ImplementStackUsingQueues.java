package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	// https://leetcode.com/submissions/detail/579774253/
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False
	}

}

class MyStack {

	Queue<Integer> main;
	Queue<Integer> sub;

	public MyStack() {
		this.main = new LinkedList<Integer>();
		this.sub = new LinkedList<Integer>();
	}

	public void push(int x) {
		while (!this.main.isEmpty()) {
			this.sub.add(this.main.poll());
		}
		this.main.add(x);
		while (!this.sub.isEmpty()) {
			this.main.add(this.sub.poll());
		}

	}

	public int pop() {
		return this.main.poll();
	}

	public int top() {
		return this.main.peek();
	}

	public boolean empty() {
		return this.main.isEmpty();
	}

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */