package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventsThatCanBeAttendedII {

	// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/submissions/1690571829/
	public static void main(String[] args) {
		MaximumNumberOfEventsThatCanBeAttendedII test = new MaximumNumberOfEventsThatCanBeAttendedII();
		System.out.println(test.maxValue(new int[][] {
			{ 1, 2, 4 },
			{ 3, 4, 3 },
			{ 2, 3, 1 }
		}, 2));
		System.out.println(test.maxValue(new int[][] {
			{ 1, 2, 4 },
			{ 3, 4, 3 },
			{ 2, 3, 10 }
		}, 2));
		System.out.println(test.maxValue(new int[][] {
			{ 1, 1, 2 },
			{ 2, 2, 2 },
			{ 3, 3, 3 },
			{ 4, 4, 4 }
		}, 3));
	}

	public int maxValue(int[][] events, int k) {
		if (k == 1) {
			return Arrays.stream(events).max(Comparator.comparingInt(e -> e[2])).orElseThrow()[2];
		} else {
			Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
			int length = events.length;
			int[][] dp = new int[length + 1][k + 1];
			for (int i = length - 1; i >= 0; i--) {
				int next = this.binarySearch(events, events[i][1], i + 1, length);
				for (int j = 1; j <= k; j++) {
					dp[i][j] = Math.max(dp[i + 1][j], dp[next][j - 1] + events[i][2]);
				}
			}
			return dp[0][k];
		}
	}

	private int binarySearch(int[][] events, int target, int start, int end) {
		while (start < end) {
			int mid = ((end - start) / 2) + start;
			if (target >= events[mid][0]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

}
