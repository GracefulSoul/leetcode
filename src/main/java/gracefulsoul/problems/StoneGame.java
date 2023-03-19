package gracefulsoul.problems;

public class StoneGame {

	// https://leetcode.com/problems/stone-game/submissions/917784230/
	public static void main(String[] args) {
		StoneGame test = new StoneGame();
		System.err.println(test.stoneGame(new int[] { 5, 3, 4, 5 }));
		System.err.println(test.stoneGame(new int[] { 3, 7, 2, 3 }));
	}

	public boolean stoneGame(int[] piles) {
		int sub = 0;
		int sum = 0;
		for (int pile : piles) {
			sum += pile;
		}
		int left = 0;
		int right = piles.length - 1;
		while (left <= right) {
			if (piles[left] > piles[right]) {
				sub += piles[left++];
			} else {
				sub += piles[right--];
			}
		}
		return sub > sum / 2;
	}

}
