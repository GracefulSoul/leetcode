package gracefulsoul.problems;

public class CountSubmatricesWithEqualFrequencyOfXAndY {

	// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/submissions/1952896906/
	public static void main(String[] args) {
		CountSubmatricesWithEqualFrequencyOfXAndY test = new CountSubmatricesWithEqualFrequencyOfXAndY();
		System.out.println(test.numberOfSubmatrices(new char[][] {
			{ 'X', 'Y', '.' },
			{ 'Y', '.', '.' }
		}));
		System.out.println(test.numberOfSubmatrices(new char[][] {
			{ 'X', 'X' },
			{ 'X', 'Y' }
		}));
		System.out.println(test.numberOfSubmatrices(new char[][] {
			{ '.', '.' },
			{ '.', '.' }
		}));
	}

	public int numberOfSubmatrices(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[] sumX = new int[cols];
		int[] sumY = new int[cols];
		int result = 0;
		for (int i = 0; i < rows; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 'X') {
					x++;
				} else if (grid[i][j] == 'Y') {
					y++;
				}
				sumX[j] += x;
				sumY[j] += y;
				if (sumX[j] > 0 && sumX[j] == sumY[j]) {
					result++;
				}
			}
		}
		return result;
	}

}
