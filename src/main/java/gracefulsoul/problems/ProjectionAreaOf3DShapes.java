package gracefulsoul.problems;

public class ProjectionAreaOf3DShapes {

	// https://leetcode.com/problems/projection-area-of-3d-shapes/submissions/921266447/
	public static void main(String[] args) {
		ProjectionAreaOf3DShapes test = new ProjectionAreaOf3DShapes();
		System.out.println(test.projectionArea(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
		System.out.println(test.projectionArea(new int[][] {
			{ 2 }
		}));
		System.out.println(test.projectionArea(new int[][] {
			{ 1, 0 },
			{ 0, 2 }
		}));
	}

	public int projectionArea(int[][] grid) {
		int result = 0;
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < length; j++) {
				x = Math.max(x, grid[i][j]);
				y = Math.max(y, grid[j][i]);
				if (grid[i][j] > 0) {
					result++;
				}
			}
			result += x + y;
		}
		return result;
	}

}
