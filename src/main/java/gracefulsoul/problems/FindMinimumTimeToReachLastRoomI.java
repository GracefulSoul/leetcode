package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumTimeToReachLastRoomI {

	// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/submissions/1628591467/
	public static void main(String[] args) {
		FindMinimumTimeToReachLastRoomI test = new FindMinimumTimeToReachLastRoomI();
		System.out.println(test.minTimeToReach(new int[][] {
			{ 0, 4 },
			{ 4, 4 }
		}));
		System.out.println(test.minTimeToReach(new int[][] {
			{ 0, 0, 0 },
			{ 0, 0, 0 }
		}));
		System.out.println(test.minTimeToReach(new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 }
	};

	public int minTimeToReach(int[][] moveTime) {
		int rows = moveTime.length;
		int cols = moveTime[0].length;
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int[][] dp = new int[rows][cols];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		queue.offer(new int[] { 0, 0, 0 });
		dp[0][0] = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int time = curr[0];
			int x = curr[1];
			int y = curr[2];
			if (x == rows - 1 && y == cols - 1) {
				return time;
			} else {
				for (int[] direction : DIRECTIONS) {
					int dx = x + direction[0];
					int dy = y + direction[1];
					if (dx >= 0 && dx < rows && dy >= 0 && dy < cols) {
						int next = Math.max(moveTime[dx][dy] - time, 0) + time + 1;
						if (next < dp[dx][dy]) {
							dp[dx][dy] = next;
							queue.offer(new int[] { next, dx, dy });
						}
					}
				}
			}
		}
		return -1;
	}

}
