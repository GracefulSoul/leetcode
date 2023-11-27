package gracefulsoul.problems;

public class CountNegativeNumbersInASortedMatrix {

	// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/submissions/966557036/
	public static void main(String[] args) {
		CountNegativeNumbersInASortedMatrix test = new CountNegativeNumbersInASortedMatrix();
		System.out.println(test.countNegatives(new int[][] {
			{ 4, 3, 2, -1 },
			{ 3, 2, 1, -1 },
			{ 1, 1, -1, -2 },
			{ -1, -1, -2, -3 }
		}));
		System.out.println(test.countNegatives(new int[][] {
			{ 3, 2 },
			{ 1, 0 }
		}));
	}

	public int countNegatives(int[][] grid) {
		int result = 0;
		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0, right = col - 1; i < row; i++) {
			int left = 0;
			while (left <= right) {
				int mid = left + ((right - left) / 2);
				if (grid[i][mid] < 0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			result += col - left;
			right = left - 1;
		}
		return result;
	}

}
