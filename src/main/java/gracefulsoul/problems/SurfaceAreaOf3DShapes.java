package gracefulsoul.problems;

public class SurfaceAreaOf3DShapes {

	// https://leetcode.com/problems/surface-area-of-3d-shapes/submissions/927158316/
	public static void main(String[] args) {
		SurfaceAreaOf3DShapes test = new SurfaceAreaOf3DShapes();
		System.out.println(test.surfaceArea(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
		System.out.println(test.surfaceArea(new int[][] {
			{ 1, 1, 1 },
			{ 1, 0, 1 },
			{ 1, 1, 1 }
		}));
		System.out.println(test.surfaceArea(new int[][] {
			{ 2, 2, 2 },
			{ 2, 1, 2 },
			{ 2, 2, 2 }
		}));
	}

	public int surfaceArea(int[][] grid) {
		int result = 0;
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (grid[i][j] > 0) {
					result += (grid[i][j] * 4) + 2;
				}
				if (i > 0) {
					result -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
				}
				if (j > 0) {
					result -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
				}
			}
		}
		return result;
	}

}
