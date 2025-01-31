package gracefulsoul.problems;

import java.util.concurrent.Semaphore;

public class TheDiningPhilosophers {

	// https://leetcode.com/problems/the-dining-philosophers/submissions/1525922960/
	public static void main(String[] args) throws InterruptedException {
		DiningPhilosophers test = new DiningPhilosophers();
		test.wantsToEat(1
				, () -> System.out.println("pickLeftFork")
				, () -> System.out.println("pickRightFork")
				, () -> System.out.println("eat")
				, () -> System.out.println("putLeftFork")
				, () -> System.out.println("putRightFork"));
	}

}

class DiningPhilosophers {

	private final Semaphore semaphore;

	public DiningPhilosophers() {
		this.semaphore = new Semaphore(1);
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher,
			Runnable pickLeftFork,
			Runnable pickRightFork,
			Runnable eat,
			Runnable putLeftFork,
			Runnable putRightFork) throws InterruptedException {
		this.semaphore.acquire();
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();
		this.semaphore.release();
	}

}
