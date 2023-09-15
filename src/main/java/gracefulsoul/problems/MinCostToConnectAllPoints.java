package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MinCostToConnectAllPoints {

	// https://leetcode.com/problems/min-cost-to-connect-all-points/submissions/1050026115/
	public static void main(String[] args) {
		MinCostToConnectAllPoints test = new MinCostToConnectAllPoints();
		System.out.println(test.minCostConnectPoints(new int[][] {
			{ 0, 0 },
			{ 2, 2 },
			{ 3, 10 },
			{ 5, 2 },
			{ 7, 0 }
		}));
		System.out.println(test.minCostConnectPoints(new int[][] {
			{ 3, 12 },
			{ -2, 5 },
			{ -4, 1 }
		}));

	}

	public int minCostConnectPoints(int[][] points) {
		int length = points.length;
		Set<Integer> set = new HashSet<>();
		set.add(0);
		int[] dist = new int[length];
		for (int i = 1; i < length; i++) {
			dist[i] = this.find(points, 0, i);
		}
		int result = 0;
		while (set.size() != length) {
			int next = -1;
			for (int i = 0; i < length; i++) {
				if (set.contains(i)) {
					continue;
				}
				if (next == -1 || dist[next] > dist[i]) {
					next = i;
				}
			}
			set.add(next);
			result += dist[next];
			for (int i = 0; i < length; i++) {
				if (!set.contains(i)) {
					dist[i] = Math.min(dist[i], this.find(points, i, next));
				}
			}
		}
		return result;
	}

	private int find(int[][] points, int x, int y) {
		return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
	}

}
