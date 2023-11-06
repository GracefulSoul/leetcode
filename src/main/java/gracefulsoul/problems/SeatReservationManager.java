package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatReservationManager {

	// https://leetcode.com/problems/seat-reservation-manager/submissions/1092707270/
	public static void main(String[] args) {
		SeatManager seatManager = new SeatManager(5);	// Initializes a SeatManager with 5 seats.
		System.out.println(seatManager.reserve());		// All seats are available, so return the lowest numbered seat, which is 1.
		System.out.println(seatManager.reserve());		// The available seats are [2,3,4,5], so return the lowest of them, which is 2.
		seatManager.unreserve(2);						// Unreserve seat 2, so now the available seats are [2,3,4,5].
		System.out.println(seatManager.reserve());		// The available seats are [2,3,4,5], so return the lowest of them, which is 2.
		System.out.println(seatManager.reserve());		// The available seats are [3,4,5], so return the lowest of them, which is 3.
		System.out.println(seatManager.reserve());		// The available seats are [4,5], so return the lowest of them, which is 4.
		System.out.println(seatManager.reserve());		// The only available seat is seat 5, so return 5.
		seatManager.unreserve(5);						// Unreserve seat 5, so now the available seats are [5].
	}

}

class SeatManager {

	private Queue<Integer> queue;
	private int count;

	public SeatManager(int n) {
		this.count = 1;
		this.queue = new PriorityQueue<>();
	}

	public int reserve() {
		if (this.queue.isEmpty()) {
			return this.count++;
		} else {
			return this.queue.poll();
		}
	}

	public void unreserve(int seatNumber) {
		this.queue.add(seatNumber);
	}

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */