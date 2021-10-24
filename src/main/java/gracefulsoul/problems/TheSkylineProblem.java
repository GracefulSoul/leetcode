package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

	// https://leetcode.com/submissions/detail/576201565/
	public static void main(String[] args) {
		TheSkylineProblem test = new TheSkylineProblem();
		System.out.println(test.getSkyline(new int[][] {
			new int[] { 2, 9, 10 },
			new int[] { 3, 7, 15 },
			new int[] { 5, 12, 12 },
			new int[] { 15, 20, 10 },
			new int[] { 19, 24, 8 }
		}));
		System.out.println(test.getSkyline(new int[][] {
			new int[] { 0, 2, 3 },
			new int[] { 2, 5, 3 }
		}));
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
		int next = 0;
		int[] point = null;
		while (point != null || next < buildings.length) {
			if (point == null) {
				point = buildings[next];
				this.addPoint(result, point[0], point[2]);
			} else if (next < buildings.length && buildings[next][0] <= point[1]) {
				if (buildings[next][2] > point[2]) {
					if (buildings[next][0] == point[0]) {
						result.remove(result.size() - 1);
					}
					if (buildings[next][1] <= point[1]) {
						queue.add(point);
					}
					point = buildings[next];
					this.addPoint(result, point[0], point[2]);
				} else if (buildings[next][1] > point[1]) {
					queue.add(buildings[next]);
				}
				next++;
			} else {
				int[] lower = queue.poll();
				while (lower != null && lower[1] <= point[1]) {
					lower = queue.poll();
				}
				if (lower == null) {
					this.addPoint(result, point[1], 0);
				} else if (lower[2] < point[2]) {
					this.addPoint(result, point[1], lower[2]);
				}
				point = lower;
			}
		}
		return result;
	}

	private void addPoint(List<List<Integer>> result, int p, int h) {
		List<Integer> temp = new ArrayList<>();
		temp.add(p);
		temp.add(h);
		result.add(temp);
	}

}
