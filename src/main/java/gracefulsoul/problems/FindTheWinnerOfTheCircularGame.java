package gracefulsoul.problems;

public class FindTheWinnerOfTheCircularGame {

	// https://leetcode.com/problems/find-the-winner-of-the-circular-game/submissions/1314002680/
	public static void main(String[] args) {
		FindTheWinnerOfTheCircularGame test = new FindTheWinnerOfTheCircularGame();
		System.out.println(test.findTheWinner(5, 2));
		System.out.println(test.findTheWinner(6, 5));
	}

	public int findTheWinner(int n, int k) {
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = (result + k) % i;
		}
		return result + 1;
	}

}
