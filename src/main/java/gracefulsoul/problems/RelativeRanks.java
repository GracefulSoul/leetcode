package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class RelativeRanks {

	// https://leetcode.com/submissions/detail/706588616/
	public static void main(String[] args) {
		RelativeRanks test = new RelativeRanks();
		PrintUtil.print(test.findRelativeRanks(new int[] { 5, 4, 3, 2, 1 }));
		PrintUtil.print(test.findRelativeRanks(new int[] { 10, 3, 8, 9, 4 }));
	}

	public String[] findRelativeRanks(int[] score) {
		int length = score.length;
		int max = 0;
		for (int s : score) {
			if (s > max) {
				max = s;
			}
		}
		int[] map = new int[max + 1];
		for (int idx = 0; idx < length; idx++) {
			map[score[idx]] = idx + 1;
		}
		String[] result = new String[length];
		int count = 0;
		for (int idx = max; idx >= 0; idx--) {
			if (map[idx] != 0) {
				switch (++count) {
					case 1: result[map[idx] - 1] = "Gold Medal"; break;
					case 2: result[map[idx] - 1] = "Silver Medal"; break;
					case 3: result[map[idx] - 1] = "Bronze Medal"; break;
					default: result[map[idx] - 1] = String.valueOf(count);
				}
			}
		}
		return result;
	}

}
