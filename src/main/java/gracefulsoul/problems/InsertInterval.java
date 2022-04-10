package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class InsertInterval {

	// https://leetcode.com/submissions/detail/503763321/
	public static void main(String[] args) {
		InsertInterval test  = new InsertInterval();
		PrintUtil.print(test.insert(new int[][] {
			new int[] { 1, 3 },
			new int[] { 6, 9 }
		}, 
			new int[] { 2, 5 }
		));
		PrintUtil.print(test.insert(new int[][] {
			new int[] { 1, 2 },
			new int[] { 3, 5 },
			new int[] { 6, 7 },
			new int[] { 8, 10 },
			new int[] { 12, 16 }
		},
			new int[] { 4, 8 }
		));
		PrintUtil.print(test.insert(new int[][] {
		},
			new int[] { 5, 7 }
		));
		PrintUtil.print(test.insert(new int[][] {
			new int[] { 1, 5 }
		},
			new int[] { 2, 3 }
		));
		PrintUtil.print(test.insert(new int[][] {
			new int[] { 1, 5 }
		},
			new int[] { 2, 7 }
		));
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] > newInterval[1]) {
				result.add(newInterval);
				newInterval = intervals[i];
			} else if (intervals[i][1] >= newInterval[0]) {
				newInterval = new int[] { Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1]) };
			} else {
				result.add(intervals[i]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}

}
