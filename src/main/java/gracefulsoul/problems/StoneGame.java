package gracefulsoul.problems;

public class StoneGame {

	// https://leetcode.com/problems/stone-game/submissions/917864497/
	public static void main(String[] args) {
		StoneGame test = new StoneGame();
		System.err.println(test.stoneGame(new int[] { 5, 3, 4, 5 }));
		System.err.println(test.stoneGame(new int[] { 3, 7, 2, 3 }));
	}

	public boolean stoneGame(int[] piles) {
		int sum = 0;
		int total = 0;
		for (int pile : piles) {
			total += pile;
		}
		int left = 0;
		int right = piles.length - 1;
		while (left <= right) {
			if (piles[left] > piles[right]) {
				sum += piles[left++];
			} else {
				sum += piles[right--];
			}
		}
		return sum > total / 2;
	}

}
