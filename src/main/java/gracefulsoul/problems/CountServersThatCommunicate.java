package gracefulsoul.problems;

public class CountServersThatCommunicate {

	// https://leetcode.com/problems/count-servers-that-communicate/submissions/1517400681/
	public static void main(String[] args) {
		CountServersThatCommunicate test = new CountServersThatCommunicate();
		System.out.println(test.countServers(new int[][] {
			{ 1, 0 },
			{ 0, 1 }
		}));
		System.out.println(test.countServers(new int[][] {
			{ 1, 0 },
			{ 1, 1 }
		}));
		System.out.println(test.countServers(new int[][] {
			{ 1, 1, 0, 0 },
			{ 0, 0, 1, 0 },
			{ 0, 0, 1, 0 },
			{ 0, 0, 0, 1 }
		}));
	}

	public int countServers(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int rowLength = grid.length;
		int colLength = grid[0].length;
		int[] rowCounts = new int[rowLength];
		int[] colCounts = new int[colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (grid[i][j] == 1) {
					rowCounts[i]++;
					colCounts[j]++;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (grid[i][j] == 1 && (rowCounts[i] > 1 || colCounts[j] > 1)) {
					result++;
				}
			}
		}
		return result;
	}

}
