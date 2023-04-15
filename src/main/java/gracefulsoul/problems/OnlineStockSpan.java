package gracefulsoul.problems;

import java.util.Stack;

public class OnlineStockSpan {

	// https://leetcode.com/problems/online-stock-span/submissions/933962595/
	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		System.out.println(stockSpanner.next(100)); // return 1
		System.out.println(stockSpanner.next(80));  // return 1
		System.out.println(stockSpanner.next(60));  // return 1
		System.out.println(stockSpanner.next(70));  // return 2
		System.out.println(stockSpanner.next(60));  // return 1
		System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
		System.out.println(stockSpanner.next(85));  // return 6
	}

}

class StockSpanner {

	private Stack<int[]> stack;

	public StockSpanner() {
		this.stack = new Stack<>();
	}

	public int next(int price) {
		int span = 1;
		while (!this.stack.isEmpty() && price >= this.stack.peek()[0]) {
			span += this.stack.pop()[1];
		}
		this.stack.push(new int[] { price, span });
		return span;
	}

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */