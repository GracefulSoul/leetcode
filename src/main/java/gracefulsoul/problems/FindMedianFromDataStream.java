package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

	// https://leetcode.com/submissions/detail/599609758/
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian()); // return 2.0
	}

}

class MedianFinder {

	private Queue<Integer> queue;
	private Queue<Integer> reverse;
	private boolean isEven;

	public MedianFinder() {
		this.queue = new PriorityQueue<>();
		this.reverse = new PriorityQueue<>((a, b) -> b - a);
		this.isEven = true;
	}

	public void addNum(int num) {
		if (this.isEven) {
			this.queue.add(num);
			this.reverse.add(this.queue.poll());
		} else {
			this.reverse.add(num);
			this.queue.add(this.reverse.poll());
		}
		this.isEven = !this.isEven;
	}

	public double findMedian() {
		if (this.isEven) {
			return (this.queue.peek() + this.reverse.peek()) / 2.0;
		} else {
			return this.reverse.peek();
		}
	}

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */