package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkRecoveryPathways {

	// https://leetcode.com/problems/network-recovery-pathways/submissions/2054753536/
	public static void main(String[] args) {
		NetworkRecoveryPathways test = new NetworkRecoveryPathways();
		System.out.println(test.findMaxPathScore(new int[][] {
			{ 0, 1, 5 },
			{ 1, 3, 10 },
			{ 0, 2, 3 },
			{ 2, 3, 4 }
		}, new boolean[] { true, true, true, true }, 10));
		System.out.println(test.findMaxPathScore(new int[][] {
			{ 0, 1, 7 },
			{ 1, 4, 5 },
			{ 0, 2, 6 },
			{ 2, 3, 6 },
			{ 3, 4, 2 },
			{ 2, 4, 6 }
		}, new boolean[] { true, true, true, false, true }, 12));
	}

	@SuppressWarnings("unchecked")
	public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
		int n = online.length;
		List<int[]>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] indegree = new int[n];
		for (int[] edge : edges) {
			graph[edge[0]].add(new int[] { edge[1], edge[2] });
			indegree[edge[1]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		List<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			list.add(curr);
			for (int[] edge : graph[curr]) {
				if (--indegree[edge[0]] == 0) {
					queue.offer(edge[0]);
				}
			}
		}
		int left = 0;
		int right = 1000000000;
		int result = -1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			long quarter = Long.MAX_VALUE / 4;
			long[] dp = new long[n];
			Arrays.fill(dp, quarter);
			dp[0] = 0;
			for (int num : list) {
				if (dp[num] == quarter || (num != 0 && num != n - 1 && !online[num])) {
					continue;
				}
				for (int[] edge : graph[num]) {
					if (edge[1] < mid || (edge[0] != n - 1 && !online[edge[0]])) {
						continue;
					}
					dp[edge[0]] = Math.min(dp[edge[0]], dp[num] + edge[1]);
				}
			}
			if (dp[n - 1] <= k) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

}
