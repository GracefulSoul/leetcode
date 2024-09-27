package gracefulsoul.problems;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

	// https://leetcode.com/problems/fizz-buzz-multithreaded/submissions/1403783246/
	public static void main(String[] args) {
		FizzBuzz2 test = new FizzBuzz2(15);
		new Thread(() -> {
			try {
				test.fizz(() -> System.out.println("fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				test.buzz(() -> System.out.println("buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				test.fizzbuzz(() -> System.out.println("fizzbuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				test.number((num) -> System.out.println(num));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}

class FizzBuzz2 {

	private int n;
	private int count = 1;

	public FizzBuzz2(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		while (this.count <= this.n) {
			if (this.count % 3 != 0 || this.count % 5 == 0) {
				wait();
				continue;
			}
			printFizz.run();
			this.count++;
			notifyAll();
		}
	}

	// printBuzz.run() outputs "buzz".
	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		while (this.count <= this.n) {
			if (this.count % 5 != 0 || this.count % 3 == 0) {
				wait();
				continue;
			}
			printBuzz.run();
			this.count++;
			notifyAll();
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (this.count <= this.n) {
			if (this.count % 15 != 0) {
				wait();
				continue;
			}
			printFizzBuzz.run();
			this.count++;
			notifyAll();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {
		while (this.count <= this.n) {
			if (this.count % 3 == 0 || this.count % 5 == 0) {
				wait();
				continue;
			}
			printNumber.accept(this.count);
			this.count++;
			notifyAll();
		}
	}

}
