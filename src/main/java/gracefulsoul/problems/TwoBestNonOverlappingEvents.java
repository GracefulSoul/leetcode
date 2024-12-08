package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TwoBestNonOverlappingEvents {

	// https://leetcode.com/problems/two-best-non-overlapping-events/submissions/1473115722/
	public static void main(String[] args) {
		TwoBestNonOverlappingEvents test = new TwoBestNonOverlappingEvents();
		System.out.println(test.maxTwoEvents(new int[][] {
			{ 1, 3, 2 },
			{ 4, 5, 2 },
			{ 2, 4, 3 }
		}));
		System.out.println(test.maxTwoEvents(new int[][] {
			{ 1, 3, 2 },
			{ 4, 5, 2 },
			{ 1, 5, 5 }
		}));		System.out.println(test.maxTwoEvents(new int[][] {
			{ 1, 5, 3 },
			{ 1, 5, 1 },
			{ 6, 6, 5 }
		}));
	}

	public int maxTwoEvents(int[][] events) {
		Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int max = 0;
		int result = 0;
		for (int[] event : events) {
			int start = event[0];
			while (!queue.isEmpty() && queue.peek()[0] < start) {
				max = Math.max(max, queue.remove()[1]);
			}
			result = Math.max(result, event[2] + max);
			queue.add(new int[] { event[1], event[2] });
		}
		return result;
	}

}
