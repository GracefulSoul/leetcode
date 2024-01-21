package gracefulsoul.problems;

public class DivisorGame {

	// https://leetcode.com/problems/divisor-game/submissions/1152118125/
	public static void main(String[] args) {
		DivisorGame test = new DivisorGame();
		System.out.println(test.divisorGame(2));
		System.out.println(test.divisorGame(3));
	}

	public boolean divisorGame(int n) {
		return n % 2 == 0;
	}

}
