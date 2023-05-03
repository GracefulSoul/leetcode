package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {

	// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/submissions/943772698/
	public static void main(String[] args) {
		XOfAKindInADeckOfCards test = new XOfAKindInADeckOfCards();
		System.out.println(test.hasGroupsSizeX(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }));
		System.out.println(test.hasGroupsSizeX(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 }));
	}

	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : deck) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int result = 0;
		for (int num : map.values()) {
			result = this.getGcd(num, result);
		}
		return result > 1;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
