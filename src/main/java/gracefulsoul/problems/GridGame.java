package gracefulsoul.problems;

public class GridGame {

	// https://leetcode.com/problems/grid-game/submissions/1515261371/
	public static void main(String[] args) {
		GridGame test = new GridGame();
		System.out.println(test.gridGame(new int[][] {
			{ 2, 5, 4 },
			{ 1, 5, 1 }
		}));
		System.out.println(test.gridGame(new int[][] {
			{ 3, 3, 1 },
			{ 8, 5, 2 }
		}));
		System.out.println(test.gridGame(new int[][] {
			{ 1, 3, 1, 15 },
			{ 1, 3, 3, 1 }
		}));
	}

	public long gridGame(int[][] grid) {
		long right = 0;
		for (int num : grid[0]) {
			right += num;
		}
		long left = 0;
		long result = Long.MAX_VALUE;
		for (int i = 0; i < grid[0].length; i++) {
			right -= grid[0][i];
			result = Math.min(result, Math.max(right, left));
			left += grid[1][i];
		}
		return result;
	}

}
