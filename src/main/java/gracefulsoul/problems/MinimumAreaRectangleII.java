package gracefulsoul.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangleII {

	// https://leetcode.com/problems/minimum-area-rectangle-ii/submissions/
	public static void main(String[] args) {
		MinimumAreaRectangleII test = new MinimumAreaRectangleII();
		System.out.println(test.minAreaFreeRect(new int[][] {
			{ 1, 2 },
			{ 2, 1 },
			{ 1, 0 },
			{ 0, 1 }
		}));
		System.out.println(test.minAreaFreeRect(new int[][] {
			{ 0, 1 },
			{ 2, 1 },
			{ 1, 1 },
			{ 1, 0 },
			{ 2, 0 }
		}));
		System.out.println(test.minAreaFreeRect(new int[][] {
			{ 0, 3 },
			{ 1, 2 },
			{ 3, 1 },
			{ 1, 3 },
			{ 2, 1 }
		}));
	}

	public double minAreaFreeRect(int[][] points) {
		int length = points.length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] point : points) {
			map.putIfAbsent(point[0], new HashSet<>());
			map.get(point[0]).add(point[1]);
		}
		double result = Double.MAX_VALUE;
		for (int i = 0; i < length - 2; i++) {
			for (int j = i + 1; j < length - 1; j++) {
				int dx1 = points[j][0] - points[i][0];
				int dy1 = points[j][1] - points[i][1];
				for (int k = j + 1; k < length; k++) {
					int dx2 = points[k][0] - points[i][0];
					int dy2 = points[k][1] - points[i][1];
					if ((dy2 * dy1) + (dx2 * dx1) == 0) {
						int x = dx1 + points[k][0];
						int y = dy1 + points[k][1];
						if (map.containsKey(x) && map.get(x).contains(y)) {
							double area = Math.sqrt((dx1 * dx1) + (dy1 * dy1)) * Math.sqrt((dx2 * dx2) + (dy2 * dy2));
							if (area < result) {
								result = area;
							}
						}
					}
				}
			}
		}
		return result == Double.MAX_VALUE ? 0 : result;
	}

}
