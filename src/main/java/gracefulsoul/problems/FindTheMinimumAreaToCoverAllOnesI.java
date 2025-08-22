package gracefulsoul.problems;

public class FindTheMinimumAreaToCoverAllOnesI {

	// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/submissions/1744170354/
	public static void main(String[] args) {
		FindTheMinimumAreaToCoverAllOnesI test = new FindTheMinimumAreaToCoverAllOnesI();
		System.out.println(test.minimumArea(new int[][] {
			{ 0, 1, 0 },
			{ 1, 0, 1 }
		}));
		System.out.println(test.minimumArea(new int[][] {
			{ 1, 0 },
			{ 0, 0 }
		}));
	}

	public int minimumArea(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[] max = new int[] { -1, -1 };
		int[] min = new int[] { rows, cols };
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					min[0] = Math.min(min[0], i);
					max[0] = Math.max(max[0], i);
					min[1] = Math.min(min[1], j);
					max[1] = Math.max(max[1], j);
				}
			}
		}
		return (max[0] - min[0] + 1) * (max[1] - min[1] + 1);
	}

}
