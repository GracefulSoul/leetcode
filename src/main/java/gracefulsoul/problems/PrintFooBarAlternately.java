package gracefulsoul.problems;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {

	// https://leetcode.com/problems/print-foobar-alternately/submissions/1278378036/
	public static void main(String[] args) throws InterruptedException {
		FooBar fooBar = new FooBar(1);
		fooBar.foo(new Runnable() {
			@Override
			public void run() {
				System.out.println("foo");
			}
		});
		fooBar.bar(new Runnable() {
			@Override
			public void run() {
				System.out.println("bar");
			}
		});
	}

}

class FooBar {

	private int n;
	private Semaphore fooSemaphore = new Semaphore(0);
	private Semaphore barSemaphore = new Semaphore(1);

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			this.barSemaphore.acquire();
			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			this.fooSemaphore.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			this.fooSemaphore.acquire();
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			this.barSemaphore.release();
		}
	}

}
