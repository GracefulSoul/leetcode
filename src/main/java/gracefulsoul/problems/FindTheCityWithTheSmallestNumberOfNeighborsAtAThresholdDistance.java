package gracefulsoul.problems;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

	// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/submissions/1333931120/
	public static void main(String[] args) {
		FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance test = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();
		System.out.println(test.findTheCity(4, new int[][] {
			{ 0, 1, 3 },
			{ 1, 2, 1 },
			{ 1, 3, 4 },
			{ 2, 3, 1 }
		}, 4));
		System.out.println(test.findTheCity(5, new int[][] {
			{ 0, 1, 2 },
			{ 0, 4, 8 },
			{ 1, 2, 3 },
			{ 1, 4, 2 },
			{ 2, 3, 1 },
			{ 3, 4, 1 }
		}, 2));
	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] distance = new int[n][n];
		int result = 0;
		int min = n;
		for (int[] row : distance) {
			Arrays.fill(row, 10001);
		}
		for (int[] edge : edges) {
			distance[edge[0]][edge[1]] = distance[edge[1]][edge[0]] = edge[2];
		}
		for (int i = 0; i < n; i++) {
			distance[i][i] = 0;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (distance[i][j] <= distanceThreshold) {
					count++;
				}
			}
			if (count <= min) {
				result = i;
				min = count;
			}
		}
		return result;
	}

}
