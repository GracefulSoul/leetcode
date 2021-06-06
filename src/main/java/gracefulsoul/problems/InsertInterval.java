package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	// https://leetcode.com/submissions/detail/503746870/
	public static void main(String[] args) {
		InsertInterval test  = new InsertInterval();
		print(test.insert(new int[][] {
			new int[] { 1, 3 },
			new int[] { 6, 9 }
		}, 
			new int[] { 2, 5 }
		));
		print(test.insert(new int[][] {
			new int[] { 1, 2 },
			new int[] { 3, 5 },
			new int[] { 6, 7 },
			new int[] { 8, 10 },
			new int[] { 12, 16 }
		},
			new int[] { 4, 8 }
		));
		print(test.insert(new int[][] {
		},
			new int[] { 5, 7 }
		));
		print(test.insert(new int[][] {
			new int[] { 1, 5 }
		},
			new int[] { 2, 3 }
		));
		print(test.insert(new int[][] {
			new int[] { 1, 5 }
		},
			new int[] { 2, 7 }
		));
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int[] temp = newInterval;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] > temp[1]) {
				result.add(temp);
				temp = intervals[i];
			} else if (intervals[i][1] >= temp[0]) {
				temp = new int[] { Math.min(intervals[i][0], temp[0]), Math.max(intervals[i][1], temp[1]) };
			} else {
				result.add(intervals[i]);
			}
		}
		result.add(temp);
		return result.toArray(new int[result.size()][]);
	}
	
	private static void print(int[][] intervals) {
		for (int[] array : intervals) {
			System.out.println(Arrays.toString(array));
		}
	}

}
