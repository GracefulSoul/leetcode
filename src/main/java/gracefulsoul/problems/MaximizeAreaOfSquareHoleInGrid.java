package gracefulsoul.problems;

import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {

	// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/submissions/1885658026/
	public static void main(String[] args) {
		MaximizeAreaOfSquareHoleInGrid test = new MaximizeAreaOfSquareHoleInGrid();
		System.out.println(test.maximizeSquareHoleArea(0, 0, null, null));

	}

	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
		Arrays.sort(hBars);
		Arrays.sort(vBars);
		int min = Math.min(this.getMax(hBars), this.getMax(vBars));
		return min * min;
	}

	private int getMax(int[] bars) {
		int max = 1;
		int count = 1;
		for (int i = 1; i < bars.length; i++) {
			if (bars[i] - bars[i - 1] == 1) {
				count++;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}
		return max + 1;
	}

}
