package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

	// https://leetcode.com/problems/minimum-area-rectangle/submissions/983019187/
	public static void main(String[] args) {
		MinimumAreaRectangle test = new MinimumAreaRectangle();
		System.out.println(test.minAreaRect(new int[][] {
			{ 1, 1 },
			{ 1, 3 },
			{ 3, 1 },
			{ 3, 3 },
			{ 2, 2 }
		}));
		System.out.println(test.minAreaRect(new int[][] {
			{ 1, 1 },
			{ 1, 3 },
			{ 3, 1 },
			{ 3, 3 },
			{ 4, 1 },
			{ 4, 3 }
		}));
	}

	public int minAreaRect(int[][] points) {
		Arrays.sort(points, (a, b) -> a[0] - b[1] != 0 ? a[0] - b[0] : a[1] - b[1]);
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] point : points) {
			map.computeIfAbsent(point[0], integer -> new HashSet<>()).add(point[1]);
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i + 1; j < points.length; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				int area = Math.abs((x2 - x1) * (y2 - y1));
				if (area != 0 && area < result && map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
					result = area;
				}
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

}
