package gracefulsoul.problems;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {

	// https://leetcode.com/problems/set-intersection-size-at-least-two/submissions/857436052/
	public static void main(String[] args) {
		SetIntersectionSizeAtLeastTwo test = new SetIntersectionSizeAtLeastTwo();
		System.out.println(test.intersectionSizeTwo(new int[][] {
			{ 1, 3 },
			{ 3, 7 },
			{ 8, 9 }
		}));
		System.out.println(test.intersectionSizeTwo(new int[][] {
			{ 1, 3 },
			{ 1, 4 },
			{ 2, 5 },
			{ 3, 5 }
		}));
		System.out.println(test.intersectionSizeTwo(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 2, 4 },
			{ 4, 5 }
		}));
	}

	public int intersectionSizeTwo(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
		int start = intervals[0][1] - 1;
		int end = intervals[0][1];
		int size = 2;
		for (int idx = 1; idx < intervals.length; idx++) {
			if (intervals[idx][0] > start && intervals[idx][0] <= end) {
				start = end;
				end = intervals[idx][1];
				size++;
			} else if (intervals[idx][0] > end) {
				start = intervals[idx][1] - 1;
				end = intervals[idx][1];
				size += 2;
			}
		}
		return size;
	}

}
