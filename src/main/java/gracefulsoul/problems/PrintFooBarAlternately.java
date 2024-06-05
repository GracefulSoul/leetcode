package gracefulsoul.problems;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {

	// https://leetcode.com/problems/print-foobar-alternately/submissions/1278413014/
	public static void main(String[] args) throws InterruptedException {
		FooBar fooBar = new FooBar(2);
		new Thread(() -> {
			try {
				fooBar.foo(() -> System.out.print("foo"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				fooBar.bar(() -> System.out.print("bar"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}

class FooBar {

	private int n;
	private Semaphore fooSemaphore;
	private Semaphore barSemaphore;

	public FooBar(int n) {
		this.n = n;
		this.fooSemaphore = new Semaphore(1);
		this.barSemaphore = new Semaphore(0);
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < this.n; i++) {
			this.fooSemaphore.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			this.barSemaphore.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < this.n; i++) {
			this.barSemaphore.acquire();
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			this.fooSemaphore.release();
		}
	}

}
