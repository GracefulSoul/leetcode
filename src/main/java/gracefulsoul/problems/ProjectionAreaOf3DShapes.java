package gracefulsoul.problems;

public class ProjectionAreaOf3DShapes {

	// https://leetcode.com/problems/projection-area-of-3d-shapes/submissions/921256905/
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
			int[] coordinate = new int[] { 0, 0 };
			for (int j = 0; j < length; j++) {
				coordinate[0] = Math.max(coordinate[0], grid[i][j]);
				coordinate[1] = Math.max(coordinate[1], grid[j][i]);
				if (grid[i][j] > 0) {
					result++;
				}
			}
			result += coordinate[0] + coordinate[1];
		}
		return result;
	}

}
