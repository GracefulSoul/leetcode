package gracefulsoul.problems;

public class MatrixSimilarityAfterCyclicShifts {

	// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/submissions/1960975337/
	public static void main(String[] args) {
		MatrixSimilarityAfterCyclicShifts test = new MatrixSimilarityAfterCyclicShifts();
		System.out.println(test.areSimilar(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		}, 4));
		System.out.println(test.areSimilar(new int[][] {
			{ 1, 2, 1, 2 },
			{ 5, 5, 5, 5 },
			{ 6, 3, 6, 3 }
		}, 2));
		System.out.println(test.areSimilar(new int[][] {
			{ 2, 2 },
			{ 2, 2 }
		}, 3));
	}

	public boolean areSimilar(int[][] mat, int k) {
		for (int[] row : mat) {
			int length = row.length;
			for (int i = 0; i < length; i++) {
				if (row[i] != row[(i + k) % length]) {
					return false;
				}
			}
		}
		return true;
	}

}
