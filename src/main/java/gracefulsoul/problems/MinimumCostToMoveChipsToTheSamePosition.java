package gracefulsoul.problems;

public class MinimumCostToMoveChipsToTheSamePosition {

	// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/submissions/1454749017/
	public static void main(String[] args) {
		MinimumCostToMoveChipsToTheSamePosition test = new MinimumCostToMoveChipsToTheSamePosition();
		System.out.println(test.minCostToMoveChips(new int[] { 1, 2, 3 }));
		System.out.println(test.minCostToMoveChips(new int[] { 2, 2, 2, 3, 3 }));
		System.out.println(test.minCostToMoveChips(new int[] { 1, 1000000000 }));
	}

	public int minCostToMoveChips(int[] position) {
		int[] count = new int[2];
		for (int p : position) {
			count[p % 2]++;
		}
		return Math.min(count[0], count[1]);
	}

}
