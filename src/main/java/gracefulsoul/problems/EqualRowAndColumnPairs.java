package gracefulsoul.problems;

public class EqualRowAndColumnPairs {

	// https://leetcode.com/problems/equal-row-and-column-pairs/submissions/970263675/
	public static void main(String[] args) {
		EqualRowAndColumnPairs test = new EqualRowAndColumnPairs();
		System.out.println(test.equalPairs(new int[][] {
			{ 3, 2, 1 },
			{ 1, 7, 6 },
			{ 2, 7, 7 }
		}));
		System.out.println(test.equalPairs(new int[][] {
			{ 3, 1, 2, 2 },
			{ 1, 4, 4, 5 },
			{ 2, 4, 2, 2 },
			{ 2, 4, 2, 2 }
		}));
	}

	public int equalPairs(int[][] grid) {
		int result = 0;
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int k = 0;
				while (k < length) {
					if (grid[i][k] != grid[k][j]) {
						break;
					}
					k++;
				}
				result += k == length ? 1 : 0;
			}
		}
		return result;
	}

}
