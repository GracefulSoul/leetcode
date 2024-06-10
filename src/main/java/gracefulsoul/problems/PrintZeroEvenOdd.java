package gracefulsoul.problems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

	// https://leetcode.com/problems/print-zero-even-odd/submissions/1283666265/
	public static void main(String[] args) {
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
		IntConsumer consumer = System.out::print;
		new Thread(() -> {
			try {
				zeroEvenOdd.zero(consumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				zeroEvenOdd.even(consumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				zeroEvenOdd.odd(consumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}

class ZeroEvenOdd {

	private int n;
	private Semaphore zeroSemaphore;
	private Semaphore evenSemaphore;
	private Semaphore oddSemaphore;

	public ZeroEvenOdd(int n) {
		this.n = n;
		this.zeroSemaphore = new Semaphore(1);
		this.evenSemaphore = new Semaphore(0);
		this.oddSemaphore = new Semaphore(0);
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < this.n; i++) {
			this.zeroSemaphore.acquire();
			printNumber.accept(0);
			if (i % 2 == 0) {
				this.oddSemaphore.release();
			} else {
				this.evenSemaphore.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= this.n; i += 2) {
			this.evenSemaphore.acquire();
			printNumber.accept(i);
			this.zeroSemaphore.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= this.n; i += 2) {
			this.oddSemaphore.acquire();
			printNumber.accept(i);
			this.zeroSemaphore.release();
		}
	}

}