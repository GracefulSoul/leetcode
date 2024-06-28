package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {

	// https://leetcode.com/problems/maximum-total-importance-of-roads/submissions/1303004475/
	public static void main(String[] args) {
		MaximumTotalImportanceOfRoads test = new MaximumTotalImportanceOfRoads();
		System.out.println(test.maximumImportance(5, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 3 },
			{ 0, 2 },
			{ 1, 3 },
			{ 2, 4 }
		}));
		System.out.println(test.maximumImportance(5, new int[][] {
			{ 0, 3 },
			{ 2, 4 },
			{ 1, 3 }
		}));
	}

	public long maximumImportance(int n, int[][] roads) {
		long reulst = 0;
		long cost = 1;
		long[] connections = new long[n];
		for (int[] road : roads) {
			connections[road[0]]++;
			connections[road[1]]++;
		}
		Arrays.sort(connections);
		for (long connection : connections) {
			reulst += connection * (cost++);
		}
		return reulst;
	}

}
