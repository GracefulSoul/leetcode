package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		MaxPointsOnALine test = new MaxPointsOnALine();
		System.out.println(test.maxPoints(new int[][] {
			new int[] { 1, 1 },
			new int[] { 2, 2 },
			new int[] { 3, 3 }
		}));
		System.out.println(test.maxPoints(new int[][] {
			new int[] { 1, 1 },
			new int[] { 3, 2 },
			new int[] { 5, 3 },
			new int[] { 4, 1 },
			new int[] { 2, 3 },
			new int[] { 1, 4 }
		}));
	}

	// https://leetcode.com/submissions/detail/550804961/
	public int maxPoints(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		Map<List<Integer>, Integer> map = new HashMap<>();
		int result = 0;
		int len = points.length;
		for (int i = 0; i < len; i++) {
			int cnt = 0;
			int max = 0;
			for (int j = i + 1; j < len; j++) {
				int y = points[j][1] - points[i][1];
				int x = points[j][0] - points[i][0];
				if (x == 0 && y == 0) {
					cnt++;
				} else {
					List<Integer> slope = this.getSlope(y, x);
					map.put(slope, map.getOrDefault(slope, 0) + 1);
					max = Math.max(max, map.get(slope));
				}
			}
			result = Math.max(result, cnt + max + 1);
			map.clear();
		}
		return result;
	}

	public List<Integer> getSlope(int y, int x) {
		if (x == 0) {
			return Arrays.asList(1, 0);
		} else if (y == 0) {
			return Arrays.asList(0, 1);
		} else {
			int gcd = this.getGcd(y, x);
			return Arrays.asList(y / gcd, x / gcd);
		}
	}

	public int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
