package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import gracefulsoul.object.pair.keyvalue.Pair;

public class MinimumTotalDistanceTraveled {

	// https://leetcode.com/problems/minimum-total-distance-traveled/submissions/1439081312/
	public static void main(String[] args) {
		MinimumTotalDistanceTraveled test = new MinimumTotalDistanceTraveled();
		System.out.println(test.minimumTotalDistance(Arrays.asList(0, 4, 6), new int[][] {
			{ 2, 2 },
			{ 6, 2 }
		}));
		System.out.println(test.minimumTotalDistance(Arrays.asList(1, -1), new int[][] {
			{ -2, 1 },
			{ 2, 1 }
		}));
	}

	public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
		Collections.sort(robot);
		Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
		int robots = robot.size();
		int factories = factory.length;
		long[][] dp = new long[robots + 1][factories + 1];
		for (int i = 0; i < robots; i++) {
			dp[i][factories] = Long.MAX_VALUE;
		}
		for (int j = factories - 1; j >= 0; j--) {
			long prefix = 0;
			Deque<Pair<Integer, Long>> deque = new ArrayDeque<>();
			deque.offer(new Pair<>(robots, 0L));
			for (int i = robots - 1; i >= 0; i--) {
				prefix += Math.abs(robot.get(i) - factory[j][0]);
				while (!deque.isEmpty() && deque.peekFirst().getKey() > i + factory[j][1]) {
					deque.pollFirst();
				}
				while (!deque.isEmpty() && deque.peekLast().getValue() >= dp[i][j + 1] - prefix) {
					deque.pollLast();
				}
				deque.offerLast(new Pair<>(i, dp[i][j + 1] - prefix));
				dp[i][j] = deque.peekFirst().getValue() + prefix;
			}
		}
		return dp[0][0];
	}

}

