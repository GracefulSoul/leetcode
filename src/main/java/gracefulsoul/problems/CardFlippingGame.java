package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {

	// https://leetcode.com/problems/card-flipping-game/submissions/888035895/
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
		for (int i = 0; i < fronts.length; i++) {
			if (!set.contains(backs[i])) {
				result = Math.min(result, backs[i]);
			}
			if (!set.contains(fronts[i])) {
				result = Math.min(result, fronts[i]);
			}
		}
		return result % 2001;
	}

}
