package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlateStacks {

	// https://leetcode.com/problems/dinner-plate-stacks/submissions/1366210106/
	public static void main(String[] args) {
		DinnerPlates D = new DinnerPlates(2); // Initialize with capacity = 2
		D.push(1);
		D.push(2);
		D.push(3);
		D.push(4);
		D.push(5); 			// The stacks are now: 2 4
							//                     1 3 5
							//                     ﹈ ﹈ ﹈
		D.popAtStack(0); 	// Returns 2. The stacks are now:   4
							//                                1 3 5
							//                                ﹈ ﹈ ﹈
		D.push(20); 		// The stacks are now: 20 4
							//                      1 3 5
							//                      ﹈ ﹈ ﹈
		D.push(21); 		// The stacks are now: 20 4 21
							//                      1 3  5
							//                      ﹈ ﹈  ﹈
		D.popAtStack(0); 	// Returns 20. The stacks are now:   4 21
							//                                 1 3  5
							//                                 ﹈ ﹈  ﹈
		D.popAtStack(2);	// Returns 21. The stacks are now:   4
							//                                 1 3 5
							//                                 ﹈ ﹈ ﹈
		D.pop();			// Returns 5. The stacks are now:   4
							//                                1 3
							//                                ﹈ ﹈
		D.pop(); 			// Returns 4. The stacks are now: 1 3
							//                                ﹈ ﹈
		D.pop(); 			// Returns 3. The stacks are now: 1
							//                                ﹈
		D.pop(); 			// Returns 1. There are no stacks.
		D.pop(); 			// Returns -1. There are still no stacks.
	}

}

class DinnerPlates {

	private List<Stack<Integer>> stacks;
	private TreeSet<Integer> treeSet;
	private int capacity;

	public DinnerPlates(int capacity) {
		this.stacks = new ArrayList<>();
		this.treeSet = new TreeSet<>();
		this.capacity = capacity;
	}

	public void push(int val) {
		if (this.treeSet.isEmpty()) {
			this.stacks.add(new Stack<>());
			this.treeSet.add(this.stacks.size() - 1);
		}
		Stack<Integer> stack = this.stacks.get(this.treeSet.first());
		stack.push(val);
		if (stack.size() == this.capacity) {
			this.treeSet.pollFirst();
		}
	}

	public int pop() {
		if (this.stacks.isEmpty()) {
			return -1;
		} else {
			int val = this.stacks.getLast().pop();
			this.treeSet.add(this.stacks.size() - 1);
			while (!this.stacks.isEmpty() && this.stacks.getLast().isEmpty()) {
				this.stacks.removeLast();
				this.treeSet.pollLast();
			}
			return val;
		}
	}

	public int popAtStack(int index) {
		if (index >= this.stacks.size()) {
			return -1;
		} else if (index == this.stacks.size() - 1) {
			return this.pop();
		} else {
			this.treeSet.add(index);
			Stack<Integer> stack = this.stacks.get(index);
			return stack.isEmpty() ? -1 : stack.pop();
		}
	}

}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity); obj.push(val); int param_2 =
 * obj.pop(); int param_3 = obj.popAtStack(index);
 */