package gracefulsoul.problems;

public class DesignAStackWithIncrementOperation {

	// https://leetcode.com/problems/design-a-stack-with-increment-operation/submissions/1406916355/
	public static void main(String[] args) {
		CustomStack stk = new CustomStack(3); // Stack is Empty []
		stk.push(1);                          // stack becomes [1]
		stk.push(2);                          // stack becomes [1, 2]
		System.out.println(stk.pop());        // return 2 --> Return top of the stack 2, stack becomes [1]
		stk.push(2);                          // stack becomes [1, 2]
		stk.push(3);                          // stack becomes [1, 2, 3]
		stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
		stk.increment(5, 100);                // stack becomes [101, 102, 103]
		stk.increment(2, 100);                // stack becomes [201, 202, 103]
		System.out.println(stk.pop());        // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		System.out.println(stk.pop());        // return 202 --> Return top of the stack 202, stack becomes [201]
		System.out.println(stk.pop());        // return 201 --> Return top of the stack 201, stack becomes []
		System.out.println(stk.pop());        // return -1 --> Stack is empty return -1.
	}

}

class CustomStack {

	private int[] stack;
	private int top;

	public CustomStack(int maxSize) {
		this.stack = new int[maxSize];
		this.top = -1;
	}

	public void push(int x) {
		if (this.top < this.stack.length - 1) {
			this.top++;
			this.stack[this.top] = x;
		}
	}

	public int pop() {
		if (this.top != -1) {
			return this.stack[this.top--];
		}
		return -1;
	}

	public void increment(int k, int val) {
		for (int i = 0; i < Math.min(k, this.top + 1); i++) {
			this.stack[i] += val;
		}
	}

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */