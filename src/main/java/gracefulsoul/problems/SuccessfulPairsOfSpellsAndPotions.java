package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class SuccessfulPairsOfSpellsAndPotions {

	// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/submissions/1794744018/
	public static void main(String[] args) {
		SuccessfulPairsOfSpellsAndPotions test = new SuccessfulPairsOfSpellsAndPotions();
		PrintUtil.print(test.successfulPairs(new int[] { 5, 1, 3 }, new int[] { 1, 2, 3, 4, 5 }, 7));
		PrintUtil.print(test.successfulPairs(new int[] { 3, 1, 2 }, new int[] { 8, 5, 8 }, 16));
	}

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		int spellsLength = spells.length;
		int potionsLength = potions.length;
		int[] result = new int[spellsLength];
		Arrays.sort(potions);
		for (int i = 0; i < spellsLength; i++) {
			int spell = spells[i];
			int left = 0;
			int right = potionsLength - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (success <= (long) spell * potions[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			result[i] = potionsLength - left;
		}
		return result;
	}

}
