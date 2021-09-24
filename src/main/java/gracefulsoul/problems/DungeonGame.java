package gracefulsoul.problems;

public class DungeonGame {

	// https://leetcode.com/submissions/detail/559997771/
	public static void main(String[] args) {
		DungeonGame test = new DungeonGame();
		System.out.println(test.calculateMinimumHP(new int[][] {
			new int[] { -2, -3, 3 },
			new int[] { -5, -10, 1 },
			new int[] { 10, 30, -5 }
		}));
		System.out.println(test.calculateMinimumHP(new int[][] {
			new int[] { 0 }
		}));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] health = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (i == row - 1 && j == col - 1) {
					health[i][j] = Math.max(1, 1 - dungeon[i][j]);
				} else if (i == row - 1) {
					health[i][j] = Math.max(health[i][j + 1] - dungeon[i][j], 1);
				} else if (j == col - 1) {
					health[i][j] = Math.max(health[i + 1][j] - dungeon[i][j], 1);
				} else {
					health[i][j] = Math.min(Math.max(health[i + 1][j] - dungeon[i][j], 1), Math.max(health[i][j + 1] - dungeon[i][j], 1));
				}
			}
		}
		return health[0][0];
	}

}
