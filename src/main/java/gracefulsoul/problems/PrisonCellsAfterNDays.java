package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class PrisonCellsAfterNDays {

	// https://leetcode.com/problems/prison-cells-after-n-days/submissions/
	public static void main(String[] args) {
		PrisonCellsAfterNDays test = new PrisonCellsAfterNDays();
		PrintUtil.print(test.prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7));
		PrintUtil.print(test.prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 1, 0 }, 1000000000));
	}

	public int[] prisonAfterNDays(int[] cells, int n) {
        for (n = (n - 1) % 14 + 1; n > 0; n--) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
        }
        return cells;
	}

}
