package gracefulsoul.problems;

public class DesignCircularQueue {

	// https://leetcode.com/submissions/detail/772992823/
	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1)); // return True
		System.out.println(myCircularQueue.enQueue(2)); // return True
		System.out.println(myCircularQueue.enQueue(3)); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return False
		System.out.println(myCircularQueue.Rear());     // return 3
		System.out.println(myCircularQueue.isFull());   // return True
		System.out.println(myCircularQueue.deQueue());  // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		System.out.println(myCircularQueue.Rear());     // return 4
	}

}

class MyCircularQueue {

	private final int[] array;
	private int front;
	private int rear;
	private int length;

	public MyCircularQueue(int k) {
		this.array = new int[k];
		this.front = 0;
		this.rear = -1;
		this.length = 0;
	}

	public int Front() {
		return this.isEmpty() ? -1 : this.array[this.front];
	}

	public int Rear() {
		return this.isEmpty() ? -1 : this.array[this.rear];
	}

	public boolean enQueue(int val) {
		if (!this.isFull()) {
			this.rear = (this.rear + 1) % this.array.length;
			this.array[this.rear] = val;
			this.length++;
			return true;
		} else {
			return false;
		}
	}

	public boolean deQueue() {
		if (!this.isEmpty()) {
			this.front = (this.front + 1) % this.array.length;
			this.length--;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return this.length == 0;
	}

	public boolean isFull() {
		return this.length == this.array.length;
	}

}