package gracefulsoul.problems;

public class DesignCircularQueue {

	// https://leetcode.com/submissions/detail/787892870/
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

	private final int[] queue;

	private int front;
	private int rear;

	private int max;
	private int size;

	public MyCircularQueue(int k) {
		this.queue = new int[k];
		this.max = k;
		this.size = 0;
		this.front = 0;
		this.rear = -1;
	}

	public int Front() {
		return this.isEmpty() ? -1 : this.queue[this.front];
	}

	public int Rear() {
		return this.isEmpty() ? -1 : this.queue[this.rear];
	}

	public boolean enQueue(int val) {
		if (!this.isFull()) {
			this.rear = (this.rear + 1) % this.max;
			this.queue[this.rear] = val;
			this.size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean deQueue() {
		if (!this.isEmpty()) {
			this.front = (this.front + 1) % this.max;
			this.size--;
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.max;
	}

}
