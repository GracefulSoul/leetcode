package gracefulsoul.problems;

public class CellsWithOddValuesInAMatrix {

	// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/submissions/1597062222/
	public static void main(String[] args) {
		CellsWithOddValuesInAMatrix test = new CellsWithOddValuesInAMatrix();
		System.out.println(test.oddCells(2, 3, new int[][] {
			{ 0, 1 },
			{ 1, 1 }
		}));
		System.out.println(test.oddCells(2, 2, new int[][] {
			{ 1, 1 },
			{ 0, 0 }
		}));
	}

	public int oddCells(int m, int n, int[][] indices) {
		int count = 0;
		int[] rows = new int[m];
		int[] cols = new int[n];
		for (int[] indice : indices) {
			rows[indice[0]]++;
			cols[indice[1]]++;
		}
		for (int row : rows) {
			for (int col : cols) {
				if ((row + col) % 2 != 0) {
					count++;
				}
			}
		}
		return count;
	}

}
