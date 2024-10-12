package gracefulsoul.problems;

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {

	// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/submissions/1419482524/
	public static void main(String[] args) {
		DivideIntervalsIntoMinimumNumberOfGroups test = new DivideIntervalsIntoMinimumNumberOfGroups();
		System.out.println(test.minGroups(new int[][] {
			{ 5, 10 },
			{ 6, 8 },
			{ 1, 5 },
			{ 2, 3 },
			{ 1, 10 }
		}));
		System.out.println(test.minGroups(new int[][] {
			{ 1, 3 },
			{ 5, 6 },
			{ 8, 10 },
			{ 11, 13 }
		}));
	}

	public int minGroups(int[][] intervals) {
		int length = intervals.length;
		int[] left = new int[length];
		int[] right = new int[length];
		for (int i = 0; i < length; i++) {
			left[i] = intervals[i][0];
			right[i] = intervals[i][1];
		}
		Arrays.sort(left);
		Arrays.sort(right);
		int result = 0;
		for (int i = 0, j = 0; i < length; i++) {
			if (left[i] <= right[j]) {
				result++;
			} else {
				j++;
			}
		}
		return result;
	}

}
