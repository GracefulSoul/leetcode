package gracefulsoul.problems;

public class NumberOfWaysToDivideALongCorridor {

	// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/submissions/1108090595/
	public static void main(String[] args) {
		NumberOfWaysToDivideALongCorridor test = new NumberOfWaysToDivideALongCorridor();
		System.out.println(test.numberOfWays("SSPPSPS"));
		System.out.println(test.numberOfWays("PPSPSP"));
		System.out.println(test.numberOfWays("S"));
	}

	public int numberOfWays(String corridor) {
		int seat = 1;
		int plant = 0;
		int divider = 0;
		for (char c : corridor.toCharArray()) {
			seat = (seat + divider) % 1000000007;
			if (c == 'S') {
				divider = plant;
				plant = seat;
				seat = 0;
			}
		}
		return divider;
	}

}
