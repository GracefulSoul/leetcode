package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class IntervalListIntersections {

	// https://leetcode.com/problems/interval-list-intersections/submissions/1040169324/
	public static void main(String[] args) {
		IntervalListIntersections test = new IntervalListIntersections();
		PrintUtil.print(test.intervalIntersection(new int[][] {
			{ 0, 2 },
			{ 5, 10 },
			{ 13, 23 },
			{ 24, 25 }
		}, new int[][] {
			{ 1, 5 },
			{ 8, 12 },
			{ 15, 24 },
			{ 25, 26 }
		}));
		PrintUtil.print(test.intervalIntersection(new int[][] {
			{ 1, 3 },
			{ 5, 9 }
		}, new int[][] {
		}));
	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> result = new ArrayList<>();
		for (int i = 0, j = 0; i < firstList.length && j < secondList.length;) {
			int start = Math.max(firstList[i][0], secondList[j][0]);
			int end = Math.min(firstList[i][1], secondList[j][1]);
			if (start <= end) {
				result.add(new int[] { start, end });
			}
			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		return result.toArray(new int[0][0]);
	}

}
