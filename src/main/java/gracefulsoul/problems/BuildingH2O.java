package gracefulsoul.problems;

import java.util.concurrent.Semaphore;

public class BuildingH2O {

	// https://leetcode.com/problems/building-h2o/submissions/1285804415/
	public static void main(String[] args) throws InterruptedException {
		int retry = 2;
		H2O h2o = new H2O();
		new Thread(() -> {
			for (int i = 0; i < retry * 2; i++) {
				try {
					h2o.hydrogen(() -> System.out.print("H"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < retry; i++) {
				try {
					h2o.oxygen(() -> System.out.print("O"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}

class H2O {

	private Semaphore hSemaphore;
	private Semaphore oSemaphore;

	public H2O() {
		this.hSemaphore = new Semaphore(2, true);
		this.oSemaphore = new Semaphore(0, true);
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		this.hSemaphore.acquire();
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		releaseHydrogen.run();
		this.oSemaphore.release();
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		this.oSemaphore.acquire(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		this.hSemaphore.release(2);
	}

}
