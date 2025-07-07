package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfEventsThatCanBeAttended {

	// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/submissions/1689313175/
	public static void main(String[] args) {
		MaximumNumberOfEventsThatCanBeAttended test = new MaximumNumberOfEventsThatCanBeAttended();
		System.out.println(test.maxEvents(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 }
		}));
		System.out.println(test.maxEvents(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 1, 2 }
		}));
	}

	public int maxEvents(int[][] events) {
		Queue<Integer> queue = new PriorityQueue<>();
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		int i = 0;
		int result = 0;
		int day = 0;
		int length = events.length;
		while (!queue.isEmpty() || i < length) {
			if (queue.isEmpty()) {
				day = events[i][0];
			}
			while (i < length && events[i][0] <= day) {
				queue.offer(events[i++][1]);
			}
			queue.poll();
			result++;
			day++;
			while (!queue.isEmpty() && queue.peek() < day) {
				queue.poll();
			}
		}
		return result;
	}

}
