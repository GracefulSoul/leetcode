package gracefulsoul.problems;

public class MinimumDominoRotationsForEqualRow {

	// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/1083791277/
	public static void main(String[] args) {
		MinimumDominoRotationsForEqualRow test = new MinimumDominoRotationsForEqualRow();
		System.out.println(test.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
		System.out.println(test.minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 }));
	}

	public int minDominoRotations(int[] tops, int[] bottoms) {
		int result = -1;
		for (int i = 1; i <= 6; i++) {
			int curr = this.calculate(tops, bottoms, i);
			if (curr != -1 && (result == -1 || result > curr)) {
				result = curr;
			}
		}
		return result;
	}

	private int calculate(int[] tops, int[] bottoms, int index) {
		int top = 0;
		int bottom = 0;
		for (int i = 0; i < tops.length; i++) {
			if (tops[i] != index && bottoms[i] != index) {
				return -1;
			} else if (tops[i] != index) {
				top++;
			} else if (bottoms[i] != index) {
				bottom++;
			}
		}
		return Math.min(top, bottom);
	}

}
