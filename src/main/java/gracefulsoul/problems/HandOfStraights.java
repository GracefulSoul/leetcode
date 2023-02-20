package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

	// https://leetcode.com/problems/hand-of-straights/submissions/901486744/
	public static void main(String[] args) {
		HandOfStraights test = new HandOfStraights();
		System.out.println(test.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
		System.out.println(test.isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4));
	}

	public boolean isNStraightHand(int[] hand, int groupSize) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int card : hand) {
			map.put(card, map.getOrDefault(card, 0) + 1);
		}
		Arrays.sort(hand);
		for (int card : hand) {
			if (map.get(card) <= 0) {
				continue;
			}
			for (int i = 1; i < groupSize; i++) {
				int count = map.getOrDefault(card + i, 0);
				if (count > 0) {
					map.put(card + i, count - 1);
				} else {
					return false;
				}
			}
			map.put(card, map.get(card) - 1);
		}
		return true;
	}

}
