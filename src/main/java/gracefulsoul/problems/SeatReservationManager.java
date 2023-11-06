package gracefulsoul.problems;

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

	private boolean[] seats;
	private int reserved = 1;
	private int unreserved = 0;

	public SeatManager(int n) {
		this.seats = new boolean[n + 1];
	}

	public int reserve() {
		if (unreserved == 0) {
			this.seats[reserved] = true;
			return this.reserved++;
		} else {
			for (int i = 1; i < this.seats.length; i++) {
				if (!this.seats[i]) {
					this.seats[i] = true;
					this.unreserved--;
					return i;
				}
			}
		}
		return -1;
	}

	public void unreserve(int seatNumber) {
		this.unreserved++;
		this.seats[seatNumber] = false;
	}

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */