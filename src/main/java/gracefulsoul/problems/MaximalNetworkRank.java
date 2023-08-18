package gracefulsoul.problems;

public class MaximalNetworkRank {

	// https://leetcode.com/problems/maximal-network-rank/submissions/1024800457/
	public static void main(String[] args) {
		MaximalNetworkRank test = new MaximalNetworkRank();
		System.out.println(test.maximalNetworkRank(4, new int[][] {
			{ 0, 1 },
			{ 0, 3 },
			{ 1, 2 },
			{ 1, 3 }
		}));
		System.out.println(test.maximalNetworkRank(5, new int[][] {
			{ 0, 1 },
			{ 0, 3 },
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 3 },
			{ 2, 4 }
		}));
		System.out.println(test.maximalNetworkRank(8, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 3 },
			{ 2, 4 },
			{ 5, 6 },
			{ 5, 7 }
		}));
	}

	public int maximalNetworkRank(int n, int[][] roads) {
		boolean[][] connect = new boolean[n][n];
		int[] count = new int[n];
		for (int[] road : roads) {
			count[road[0]]++;
			count[road[1]]++;
			connect[road[0]][road[1]] = true;
			connect[road[1]][road[0]] = true;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				result = Math.max(result, count[i] + count[j] - (connect[i][j] ? 1 : 0));
			}
		}
		return result;
	}

}
