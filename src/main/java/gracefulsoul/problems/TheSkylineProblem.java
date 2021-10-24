package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

	// https://leetcode.com/submissions/detail/576219670/
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
		int index = 0;
		int[] building = null;
		while (building != null || index < buildings.length) {
			if (building == null) {
				building = buildings[index];
				this.addPoint(result, building[0], building[2]);
			} else if (index < buildings.length && buildings[index][0] <= building[1]) {
				if (buildings[index][2] > building[2]) {
					if (buildings[index][0] == building[0]) {
						result.remove(result.size() - 1);
					}
					if (buildings[index][1] <= building[1]) {
						queue.add(building);
					}
					building = buildings[index];
					this.addPoint(result, building[0], building[2]);
				} else if (buildings[index][1] > building[1]) {
					queue.add(buildings[index]);
				}
				index++;
			} else {
				int[] lower = queue.poll();
				while (lower != null && lower[1] <= building[1]) {
					lower = queue.poll();
				}
				if (lower == null) {
					this.addPoint(result, building[1], 0);
				} else if (lower[2] < building[2]) {
					this.addPoint(result, building[1], lower[2]);
				}
				building = lower;
			}
		}
		return result;
	}

	private void addPoint(List<List<Integer>> result, int point, int height) {
		List<Integer> temp = new ArrayList<>();
		temp.add(point);
		temp.add(height);
		result.add(temp);
	}

}
