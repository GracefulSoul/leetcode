package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindMissingAndRepeatedValues {

	// https://leetcode.com/problems/find-missing-and-repeated-values/submissions/1564688432/
	public static void main(String[] args) {
		FindMissingAndRepeatedValues test = new FindMissingAndRepeatedValues();
		PrintUtil.print(test.findMissingAndRepeatedValues(new int[][] {
			{ 1, 3 },
			{ 2, 2 }
		}));
		PrintUtil.print(test.findMissingAndRepeatedValues(new int[][] {
			{ 9, 1, 7 },
			{ 8, 9, 2 },
			{ 3, 4, 6 }
		}));
	}

	public int[] findMissingAndRepeatedValues(int[][] grid) {
		int length = grid.length;
		int[] result = new int[2];
		int[] counts = new int[(length * length) + 1];
		for (int[] row : grid) {
			for (int value : row) {
				if (counts[value] == 1) {
					result[0] = value;
				} else {
					counts[value]++;
				}
			}
		}
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] == 0) {
				result[1] = i;
				break;
			}
		}
		if (result[1] == 0) {
			result[1] = counts.length;
		}
		return result;
	}

}
