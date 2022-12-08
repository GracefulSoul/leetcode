package gracefulsoul.problems;

public class ReachANumber {

	// https://leetcode.com/problems/reach-a-number/submissions/856419049/
	public static void main(String[] args) {
		ReachANumber test = new ReachANumber();
		System.out.println(test.reachNumber(2));
		System.out.println(test.reachNumber(3));
	}

	public int reachNumber(int target) {
		target = Math.abs(target);
		int numMoves = 0;
		while (target > 0) {
			target -= ++numMoves; 
		}
		if (target != 0 && target % 2 != 0) {
			while (target % 2 != 0) {
				target -= ++numMoves;
			}
		}
		return numMoves;
	}

}
