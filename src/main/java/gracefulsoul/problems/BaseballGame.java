package gracefulsoul.problems;

import java.util.Stack;

public class BaseballGame {

	// https://leetcode.com/submissions/detail/814952148/
	public static void main(String[] args) {
		BaseballGame test = new BaseballGame();
		System.out.println(test.calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(test.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
		System.out.println(test.calPoints(new String[] { "1", "C" }));
	}

	public int calPoints(String[] operations) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (String operation : operations) {
			int num;
			switch (operation) {
				case "+":
					num = stack.pop();
					int add = num + stack.peek();
					sum += add;
					stack.push(num);
					stack.push(add);
					break;
				case "D":
					num = stack.peek() * 2;
					sum += num;
					stack.push(num);
					break;
				case "C":
					sum -= stack.pop();
					break;
				default:
					num = Integer.parseInt(operation);
					sum += num;
					stack.push(num);
			}
		}
		return sum;
	}

}
