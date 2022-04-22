package gracefulsoul.problems;

public class IslandPerimeter {

	// https://leetcode.com/submissions/detail/685110245/
	public static void main(String[] args) {
		IslandPerimeter test = new IslandPerimeter();
		System.out.println(test.islandPerimeter(new int[][] {
			{ 0, 1, 0, 0 },
			{ 1, 1, 1, 0 },
			{ 0, 1, 0, 0 },
			{ 1, 1, 0, 0 }
		}));
		System.out.println(test.islandPerimeter(new int[][] {
			{ 1 }
		}));
		System.out.println(test.islandPerimeter(new int[][] {
			{ 1, 0 }
		}));
	}

	public int islandPerimeter(int[][] grid) {
		int border = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					border += 4;
					if (i > 0 && grid[i - 1][j] == 1) {
						border -= 2;
					}
					if (j > 0 && grid[i][j - 1] == 1) {
						border -= 2;
					}
				}
			}
		}
		return border;
	}

}
