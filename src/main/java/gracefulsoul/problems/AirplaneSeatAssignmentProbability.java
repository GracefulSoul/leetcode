package gracefulsoul.problems;

public class AirplaneSeatAssignmentProbability {

	// https://leetcode.com/problems/airplane-seat-assignment-probability/submissions/1546050865/
	public static void main(String[] args) {
		AirplaneSeatAssignmentProbability test = new AirplaneSeatAssignmentProbability();
		System.out.println(test.nthPersonGetsNthSeat(1));
		System.out.println(test.nthPersonGetsNthSeat(2));
	}

	public double nthPersonGetsNthSeat(int n) {
		return n == 1 ? 1.0d : 0.5d;
	}

}
