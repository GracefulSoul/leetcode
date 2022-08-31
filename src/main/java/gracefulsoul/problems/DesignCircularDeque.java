package gracefulsoul.problems;

public class DesignCircularDeque {

	// https://leetcode.com/submissions/detail/787891052/
	public static void main(String[] args) {
		MyCircularDeque myCircularDeque = new MyCircularDeque(3);
		System.out.println(myCircularDeque.insertLast(1));  // return True
		System.out.println(myCircularDeque.insertLast(2));  // return True
		System.out.println(myCircularDeque.insertFront(3)); // return True
		System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
		System.out.println(myCircularDeque.getRear());      // return 2
		System.out.println(myCircularDeque.isFull());       // return True
		System.out.println(myCircularDeque.deleteLast());   // return True
		System.out.println(myCircularDeque.insertFront(4)); // return True
		System.out.println(myCircularDeque.getFront());     // return 4
	}

}

class MyCircularDeque {

	private int[] deque;

	private int front;
	private int rear;

	private int max;
	private int size;

	public MyCircularDeque(int k) {
		this.deque = new int[k];
		this.max = k;
		this.rear = 1;
	}

	public boolean insertFront(int value) {
		if (this.isFull()) {
			return false;
		} else {
			this.front = (this.front + 1) % this.max;
			this.deque[this.front] = value;
			this.size++;
			return true;
		}
	}

	public boolean insertLast(int value) {
		if (this.isFull()) {
			return false;
		} else {
			this.rear = ((this.rear - 1) + this.max) % this.max;
			this.deque[this.rear] = value;
			this.size++;
			return true;
		}
	}

	public boolean deleteFront() {
		if (this.isEmpty()) {
			return false;
		} else {
			this.front = ((this.front - 1) + this.max) % this.max;
			this.size--;
			return true;
		}
	}

	public boolean deleteLast() {
		if (this.isEmpty()) {
			return false;
		} else {
			this.rear = (this.rear + 1) % this.max;
			this.size--;
			return true;
		}
	}

	public int getFront() {
		return this.size == 0 ? -1 : this.deque[this.front];
	}

	public int getRear() {
		return this.size == 0 ? -1 : this.deque[this.rear];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.max;
	}

}
