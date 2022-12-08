package gracefulsoul.problems;

public class ReachANumber {

	// https://leetcode.com/problems/reach-a-number/submissions/856387576/
	public static void main(String[] args) {
		ReachANumber test = new ReachANumber();
		System.out.println(test.reachNumber(2));
		System.out.println(test.reachNumber(3));
	}

	public int reachNumber(int target) {
		target = Math.abs(target);
		int numMoves = 0;
		int sum = 0;
		while (sum < target) {
			numMoves++;
			sum += numMoves;
		}
		if (sum != target && (sum - target) % 2 == 1) {
			while ((sum - target) % 2 != 0) {
				numMoves++;
				sum += numMoves;
			}
		}
		return numMoves;
	}

}
