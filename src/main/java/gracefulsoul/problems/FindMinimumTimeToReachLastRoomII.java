package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumTimeToReachLastRoomII {

	// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/submissions/1628592069/
	public static void main(String[] args) {
		FindMinimumTimeToReachLastRoomII test = new FindMinimumTimeToReachLastRoomII();
		System.out.println(test.minTimeToReach(new int[][] {
			{ 0, 4 },
			{ 4, 4 }
		}));
		System.out.println(test.minTimeToReach(new int[][] {
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 1, 0 },
		{ 0, 1 },
		{ -1, 0 },
		{ 0, -1 }
	};

	public int minTimeToReach(int[][] moveTime) {
		int row = moveTime.length;
		int col = moveTime[0].length;
		int[][] dp = new int[row][col];
		for (int i = 0; i < row; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		queue.add(new int[] { 0, 0, 0 });
		moveTime[0][0] = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int time = curr[0];
			int x = curr[1];
			int y = curr[2];
			if (time < dp[x][y]) {
				if (x == row - 1 && y == col - 1) {
					return time;
				} else {
					dp[x][y] = time;
					for (int[] direction : DIRECTIONS) {
						int dx = x + direction[0];
						int dy = y + direction[1];
						if (0 <= dx && dx < row && 0 <= dy && dy < col && dp[dx][dy] == Integer.MAX_VALUE) {
							queue.add(new int[] { Math.max(moveTime[dx][dy], time) + ((x + y) % 2 + 1), dx, dy });
						}
					}
				}
			}
		}
		return -1;
	}

}
