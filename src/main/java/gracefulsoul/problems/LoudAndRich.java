package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class LoudAndRich {

	// https://leetcode.com/problems/loud-and-rich/submissions/903491335/
	public static void main(String[] args) {
		LoudAndRich test = new LoudAndRich();
		PrintUtil.print(test.loudAndRich(new int[][] {
			{ 1, 0 },
			{ 2, 1 },
			{ 3, 1 },
			{ 3, 7 },
			{ 4, 3 },
			{ 5, 3 },
			{ 6, 3 }
		}, new int[] { 3, 2, 5, 4, 6, 1, 7, 0 }));
		PrintUtil.print(test.loudAndRich(new int[][] {
		}, new int[] { 0 }));
	}

	public int[] loudAndRich(int[][] richer, int[] quiet) {
		int[] result = new int[quiet.length];
		for (int i = 0; i < quiet.length; i++) {
			result[i] = i;
		}
		while (true) {
			boolean change = false;
			for (int[] rich : richer) {
				if (quiet[result[rich[0]]] < quiet[result[rich[1]]]) {
					result[rich[1]] = result[rich[0]];
					change = true;
				}
			}
			if (!change) {
				break;
			}
		}
		return result;
	}

}
