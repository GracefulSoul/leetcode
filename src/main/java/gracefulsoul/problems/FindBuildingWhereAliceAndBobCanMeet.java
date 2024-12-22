package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class FindBuildingWhereAliceAndBobCanMeet {

	// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/submissions/1485022914/
	public static void main(String[] args) {
		FindBuildingWhereAliceAndBobCanMeet test = new FindBuildingWhereAliceAndBobCanMeet();
		PrintUtil.print(test.leftmostBuildingQueries(new int[] { 6, 4, 8, 5, 2, 7 }, new int[][] {
			{ 0, 1 },
			{ 0, 3 },
			{ 2, 4 },
			{ 3, 4 },
			{ 2, 2 }
		}));
		PrintUtil.print(test.leftmostBuildingQueries(new int[] { 5, 3, 8, 2, 6, 1, 4, 6 }, new int[][] {
			{ 0, 7 },
			{ 3, 5 },
			{ 5, 2 },
			{ 3, 0 },
			{ 1, 6 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
		int heightsLength = heights.length;
		int queriesLength = queries.length;
		List<int[]>[] graph = new ArrayList[heightsLength];
		for (int i = 0; i < heightsLength; i++) {
			graph[i] = new ArrayList<>();
		}
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int[] result = new int[queriesLength];
		Arrays.fill(result, -1);
		for (int i = 0; i < queriesLength; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			if (x < y && heights[x] < heights[y]) {
				result[i] = y;
			} else if (x > y && heights[x] > heights[y]) {
				result[i] = x;
			} else if (x == y) {
				result[i] = x;
			} else {
				graph[Math.max(x, y)].add(new int[] { Math.max(heights[x], heights[y]), i });
			}
		}
		for (int i = 0; i < heightsLength; i++) {
			while (!queue.isEmpty() && queue.peek()[0] < heights[i]) {
				result[queue.poll()[1]] = i;
			}
			for (int[] item : graph[i]) {
				queue.add(item);
			}
		}
		return result;
	}

}
