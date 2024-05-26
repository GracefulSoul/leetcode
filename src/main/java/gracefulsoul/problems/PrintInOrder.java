package gracefulsoul.problems;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

	// https://leetcode.com/problems/print-in-order/submissions/1268099185/
	public static void main(String[] args) throws InterruptedException {
		Foo foo = new Foo();
		foo.first(new Runnable() {
			@Override
			public void run() {
				System.out.print("first");
			}
		});
		foo.second(new Runnable() {
			@Override
			public void run() {
				System.out.print("second");
			}
		});
		foo.third(new Runnable() {
			@Override
			public void run() {
				System.out.println("third");
			}
		});
	}

}

class Foo {

	private Semaphore semaphore;

	public Foo() {
		this.semaphore = new Semaphore(0);
	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		this.semaphore.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (!this.semaphore.tryAcquire(1));
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		this.semaphore.release(2);
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (!this.semaphore.tryAcquire(2));
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}

}