package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfTrapezoidsI {

	// https://leetcode.com/problems/count-number-of-trapezoids-i/submissions/1844933084/
	public static void main(String[] args) {
		CountNumberOfTrapezoidsI test = new CountNumberOfTrapezoidsI();
		System.out.println(test.countTrapezoids(new int[][] {
			{ 1, 0 },
			{ 2, 0 },
			{ 3, 0 },
			{ 2, 2 },
			{ 3, 2 }
		}));
		System.out.println(test.countTrapezoids(new int[][] {
			{ 0, 0 },
			{ 1, 0 },
			{ 0, 1 },
			{ 2, 1 }
		}));
	}

	public int countTrapezoids(int[][] points) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] point : points) {
			map.put(point[1], map.getOrDefault(point[1], 0) + 1);
		}
		long sum = 0;
		long result = 0;
		for (int value : map.values()) {
			long count = (value * (value - 1L)) / 2L;
			result += count * sum;
			sum += count;
		}
		return (int) (result % 1000000007);
	}

}
