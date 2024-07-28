package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SecondMinimumTimeToReachDestination {

	// https://leetcode.com/problems/second-minimum-time-to-reach-destination/submissions/1335614777/
	public static void main(String[] args) {
		SecondMinimumTimeToReachDestination test = new SecondMinimumTimeToReachDestination();
		System.out.println(test.secondMinimum(5, new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 1, 4 },
			{ 3, 4 },
			{ 4, 5 }
		}, 3, 5));
		System.out.println(test.secondMinimum(2, new int[][] {
			{ 1, 2 }
		}, 3, 2));
	}

	@SuppressWarnings("unchecked")
	public int secondMinimum(int n, int[][] edges, int time, int change) {
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		Deque<int[]> deque = new LinkedList<>();
		int[] frequency = new int[n + 1];
		int[] distance = new int[n + 1];
		Arrays.fill(distance, -1);
		deque.offerLast(new int[] { 1, 0 });
		distance[0] = 0;
		while (deque.size() > 0) {
			int size = deque.size();
			while (size-- > 0) {
				int[] curr = deque.pollFirst();
				int next = 0;
				int temp = curr[1] / change;
				if (temp % 2 == 0) {
					next = curr[1] + time;
				} else {
					next = ((temp + 1) * change) + time;
				}
				for (int neighbor : graph[curr[0]]) {
					if (frequency[neighbor] < 2 && distance[neighbor] < next) {
						deque.offerLast(new int[] { neighbor, next });
						frequency[neighbor]++;
						distance[neighbor] = next;
						if (neighbor == n && frequency[neighbor] == 2) {
							return next;
						}
					}
				}

			}
		}
		return -1;
	}

}
