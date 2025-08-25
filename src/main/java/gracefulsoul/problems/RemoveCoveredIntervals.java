package gracefulsoul.problems;

import java.util.Arrays;

public class RemoveCoveredIntervals {

	// https://leetcode.com/problems/remove-covered-intervals/submissions/1747538512/
	public static void main(String[] args) {
		RemoveCoveredIntervals test = new RemoveCoveredIntervals();
		System.out.println(test.removeCoveredIntervals(new int[][] {
			{ 1, 4 },
			{ 3, 6 },
			{ 2, 8 }
		}));
		System.out.println(test.removeCoveredIntervals(new int[][] {
			{ 1, 4 },
			{ 2, 3 }
		}));
	}

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i, j) -> (i[0] == j[0] ? j[1] - i[1] : i[0] - j[0]));
		int result = 0;
		int curr = 0;
		for (int[] interval : intervals) {
			if (curr < interval[1]) {
				curr = interval[1];
				result++;
			}
		}
		return result;
	}

}
