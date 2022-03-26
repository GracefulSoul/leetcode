package gracefulsoul.problems;

import java.util.Arrays;

public class NonOverlappingIntervals {

	// https://leetcode.com/submissions/detail/667891646/
	public static void main(String[] args) {
		NonOverlappingIntervals test = new NonOverlappingIntervals();
		System.out.println(test.eraseOverlapIntervals(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 1, 3 }
		}));
		System.out.println(test.eraseOverlapIntervals(new int[][] {
			{ 1, 2 },
			{ 1, 2 },
			{ 1, 2 }
		}));
		System.out.println(test.eraseOverlapIntervals(new int[][] {
			{ 1, 2 },
			{ 2, 3 }
		}));
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (interval1, interval2) -> {
			return interval1[1] - interval2[1];
		});
		int end = intervals[0][1];
		int count = 1;
		for (int[] interval : intervals) {
			if (interval[0] >= end) {
				end = interval[1];
				count++;
			}
		}
		return intervals.length - count;
	}

}
