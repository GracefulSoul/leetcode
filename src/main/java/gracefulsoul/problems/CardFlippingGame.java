package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {

	// https://leetcode.com/problems/card-flipping-game/submissions/888055254/
	public static void main(String[] args) {
		CardFlippingGame test = new CardFlippingGame();
		System.out.println(test.flipgame(new int[] { 1, 2, 4, 4, 7 }, new int[] { 1, 3, 4, 1, 3 }));
		System.out.println(test.flipgame(new int[] { 1 }, new int[] { 1 }));
	}

	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> set = new HashSet<>();
		for (int idx = 0; idx < fronts.length; idx++) {
			if (fronts[idx] == backs[idx]) {
				set.add(fronts[idx]);
			}
		}
		int result = 2001;
		for (int idx = 0; idx < fronts.length; idx++) {
			if (!set.contains(backs[idx])) {
				result = Math.min(result, backs[idx]);
			}
			if (!set.contains(fronts[idx])) {
				result = Math.min(result, fronts[idx]);
			}
		}
		return result % 2001;
	}

}
