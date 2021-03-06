package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class MergeIntervals {

	// https://leetcode.com/submissions/detail/503310440/
	public static void main(String[] args) {
		MergeIntervals test = new MergeIntervals();
		PrintUtil.print(test.merge(new int[][] {
			new int[] { 1, 3 },
			new int[] { 2, 6 },
			new int[] { 8, 10 },
			new int[] { 15, 18 }
		}));
		PrintUtil.print(test.merge(new int[][] {
			new int[] { 1, 4 },
			new int[] { 0, 4 }
		}));
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
		List<int[]> result = new ArrayList<>();
		result.add(intervals[0]);
		for (int[] interval : intervals) {
			int[] temp = result.get(result.size() - 1);
			if (temp[1] >= interval[0]) {
				temp[1] = Math.max(temp[1], interval[1]);
			} else {
				result.add(interval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

}
