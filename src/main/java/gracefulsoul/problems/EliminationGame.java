package gracefulsoul.problems;

public class EliminationGame {

	// https://leetcode.com/submissions/detail/643748283/
	public static void main(String[] args) {
		EliminationGame test = new EliminationGame();
		System.out.println(test.lastRemaining(9));
		System.out.println(test.lastRemaining(1));
	}

	public int lastRemaining(int n) {
		if (n == 1) {
			return n;
		} else {
			return 2 * ((n / 2) + 1 - this.lastRemaining(n / 2));
		}
	}

}
