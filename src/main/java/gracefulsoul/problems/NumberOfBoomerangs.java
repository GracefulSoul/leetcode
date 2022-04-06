package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

	// https://leetcode.com/submissions/detail/674756122/
	public static void main(String[] args) {
		NumberOfBoomerangs test = new NumberOfBoomerangs();
		System.out.println(test.numberOfBoomerangs(new int[][] {
			{ 0, 0 },
			{ 1, 0 },
			{ 2, 0 }
		}));
		System.out.println(test.numberOfBoomerangs(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 }
		}));
		System.out.println(test.numberOfBoomerangs(new int[][] {
			{ 1, 1 }
		}));
	}

	public int numberOfBoomerangs(int[][] points) {
		int number = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				int distance = this.calculateDistance(points[i], points[j]);
				int point = map.getOrDefault(distance, 0);
				if (point > 0) {
					number += point * 2;
				}
				map.put(distance, point + 1);
			}
			map.clear();
		}
		return number;
	}

	private int calculateDistance(int[] pointA, int[] pointB) {
		int x = pointB[0] - pointA[0];
		int y = pointB[1] - pointA[1];
		return (x * x) + (y * y);
	}

}
