package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

	// https://leetcode.com/problems/snakes-and-ladders/submissions/940061660/
	public static void main(String[] args) {
		SnakesAndLadders test = new SnakesAndLadders();
		System.out.println(test.snakesAndLadders(new int[][] {
			{ -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1 },
			{ -1, 35, -1, -1, 13, -1 },
			{ -1, -1, -1, -1, -1, -1 },
			{ -1, 15, -1, -1, -1, -1 }
		}));
		System.out.println(test.snakesAndLadders(new int[][] {
			{ -1, -1 },
			{ -1, 3 }
		}));
	}

	public int snakesAndLadders(int[][] board) {
		int length = board.length;
		int[] dp = new int[length * length];
		int i = length - 1;
		int j = 0;
		int index = 0;
		int direction = 1;
		while (index < length * length) {
			dp[index++] = board[i][j];
			if (direction == 1 && j == length - 1) {
				direction = -1;
				i--;
			} else if (direction == -1 && j == 0) {
				direction = 1;
				i--;
			} else {
				j += direction;
			}
		}
		boolean[] visited = new boolean[length * length];
		Queue<Integer> queue = new LinkedList<>();
		int start = dp[0] > -1 ? dp[0] - 1 : 0;
		queue.offer(start);
		visited[start] = true;
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int cur = queue.poll();
				if (cur == length * length - 1) {
					return step;
				}
				for (int next = cur + 1; next <= Math.min(cur + 6, length * length - 1); next++) {
					int destination = dp[next] > -1 ? dp[next] - 1 : next;
					if (!visited[destination]) {
						visited[destination] = true;
						queue.offer(destination);
					}
				}
			}
			step++;
		}
		return -1;
	}

}
