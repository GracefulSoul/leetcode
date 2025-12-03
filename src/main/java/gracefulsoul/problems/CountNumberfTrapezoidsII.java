package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountNumberfTrapezoidsII {

	// https://leetcode.com/problems/count-number-of-trapezoids-ii/submissions/1845788338/
	public static void main(String[] args) {
		CountNumberfTrapezoidsII test = new CountNumberfTrapezoidsII();
		System.out.println(test.countTrapezoids(new int[][] {
			{ -3, 2 },
			{ 3, 0 },
			{ 2, 3 },
			{ 3, 2 },
			{ 2, -3 }
		}));
		System.out.println(test.countTrapezoids(new int[][] {
			{ 0, 0 },
			{ 1, 0 },
			{ 0, 1 },
			{ 2, 1 }
		}));
	}

	public int countTrapezoids(int[][] points) {
		Map<Integer, Map<Integer, Integer>> t = new HashMap<>();
		Map<Integer, Map<Integer, Integer>> v = new HashMap<>();
		int length = points.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int x = points[j][0] - points[i][0];
				int y = points[j][1] - points[i][1];
				if (x < 0 || (x == 0 && y < 0)) {
					x *= -1;
					y *= -1;
				}
				int gcd = this.getGcd(x, Math.abs(y));
				int nx = x / gcd;
				int ny = y / gcd;
				int des = nx * points[i][1] - ny * points[i][0];
				int key1 = (nx << 12) | (ny + 2000);
				int key2 = (x << 12) | (y + 2000);
				t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
				v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
			}
		}
		return this.getCount(t) - this.getCount(v) / 2;
	}

	private int getCount(Map<Integer, Map<Integer, Integer>> map) {
		long count = 0;
		for (Map<Integer, Integer> values : map.values()) {
			long sum = 0;
			for (int value : values.values()) {
				sum += value;
			}
			for (int value : values.values()) {
				sum -= value;
				count += (long) value * sum;
			}
		}
		return (int) count;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
