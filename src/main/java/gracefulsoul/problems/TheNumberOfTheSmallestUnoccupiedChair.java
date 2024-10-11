package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheNumberOfTheSmallestUnoccupiedChair {

	// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/submissions/1419014746/
	public static void main(String[] args) {
		TheNumberOfTheSmallestUnoccupiedChair test = new TheNumberOfTheSmallestUnoccupiedChair();
		System.out.println(test.smallestChair(new int[][] {
			{ 1, 4 },
			{ 2, 3 },
			{ 4, 6 }
		}, 1));
		System.out.println(test.smallestChair(new int[][] {
			{ 3, 10 },
			{ 1, 5 },
			{ 2, 6 }
		}, 0));
	}

	public int smallestChair(int[][] times, int targetFriend) {
		int result = -1;
		int start = times[targetFriend][0];
		Arrays.sort(times, (x, y) -> x[0] - y[0]);
		Queue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		Queue<Integer> chairs = new PriorityQueue<>();
		for (int i = 0, j = 0; i < times.length; i++) {
			while (!queue.isEmpty() && queue.peek()[0] <= times[i][0]) {
				chairs.offer(queue.poll()[1]);
			}
			result = chairs.isEmpty() ? j++ : chairs.poll();
			queue.offer(new int[] { times[i][1], result });
			if (times[i][0] == start) {
				break;
			}
		}
		return result;
	}

}
