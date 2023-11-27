package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {

	// https://leetcode.com/problems/minimum-number-of-refueling-stops/submissions/913448455/
	public static void main(String[] args) {
		MinimumNumberOfRefuelingStops test = new MinimumNumberOfRefuelingStops();
		System.out.println(test.minRefuelStops(1, 1, new int[][] {
		}));
		System.out.println(test.minRefuelStops(100, 1, new int[][] {
			{ 10, 100 }
		}));
		System.out.println(test.minRefuelStops(100, 10, new int[][] {
			{ 0, 60 },
			{ 20, 30 },
			{ 30, 30 },
			{ 60, 40 }
		}));
	}

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		Queue<Integer> queue = new PriorityQueue<>();
		int i = 0;
		int result = 0;
		while (startFuel < target) {
			while (i < stations.length && stations[i][0] <= startFuel) {
				queue.offer(-stations[i++][1]);
			}
			if (queue.isEmpty()) {
				return -1;
			}
			startFuel -= queue.poll();
			result++;
		}
		return result;
	}

}
