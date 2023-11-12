package gracefulsoul.problems;

import java.util.Arrays;

public class BusRoutes {

	// https://leetcode.com/problems/bus-routes/submissions/884068213/
	public static void main(String[] args) {
		BusRoutes test = new BusRoutes();
		System.out.println(test.numBusesToDestination(new int[][] {
			{ 1, 2, 7 },
			{ 3, 6, 7 }
		}, 1, 6));
		System.out.println(test.numBusesToDestination(new int[][] {
			{ 7, 12 },
			{ 4, 5, 15 },
			{ 6 },
			{ 15, 19 },
			{ 9, 12, 13 }
		}, 15, 12));
	}

	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}
		int max = 0;
		for (int[] route : routes) {
			for (int stop : route) {
				max = Math.max(max, stop);
			}
		}
		if (max < target) {
			return -1;
		}
		int n = routes.length;
		int[] station = new int[max + 1];
		Arrays.fill(station, n + 1);
		station[source] = 0;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int[] route : routes) {
				int min = n + 1;
				for (int stop : route) {
					min = Math.min(min, station[stop]);
				}
				min++;
				for (int stop : route) {
					if (station[stop] > min) {
						station[stop] = min;
						flag = true;
					}
				}
			}

		}
		return (station[target] < n + 1 ? station[target] : -1);
	}

}
