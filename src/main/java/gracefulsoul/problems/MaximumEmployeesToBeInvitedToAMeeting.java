package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumEmployeesToBeInvitedToAMeeting {

	// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/submissions/1520609766/
	public static void main(String[] args) {
		MaximumEmployeesToBeInvitedToAMeeting test = new MaximumEmployeesToBeInvitedToAMeeting();
		System.out.println(test.maximumInvitations(new int[] { 2, 2, 1, 2 }));
		System.out.println(test.maximumInvitations(new int[] { 1, 2, 0 }));
		System.out.println(test.maximumInvitations(new int[] { 3, 0, 1, 4, 1 }));
	}

	public int maximumInvitations(int[] favorite) {
		int length = favorite.length;
		boolean[] visited = new boolean[length];
		int[] indegrees = new int[length];
		for (int i = 0; i < length; i++) {
			int j = favorite[i];
			indegrees[j]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			if (indegrees[i] == 0) {
				visited[i] = true;
				queue.offer(i);
			}
		}
		int[] dp = new int[length];
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int person = favorite[curr];
			dp[person] = Math.max(dp[person], dp[curr] + 1);
			if (--indegrees[person] == 0) {
				visited[person] = true;
				queue.offer(person);
			}
		}
		int result = 0;
		int max = 0;
		for (int i = 0; i < length; i++) {
			if (!visited[i]) {
				int num = 0;
				for (int j = i; !visited[j]; j = favorite[j]) {
					visited[j] = true;
					num++;
				}
				if (num == 2) {
					max += 2 + dp[i] + dp[favorite[i]];
				} else {
					result = Math.max(result, num);
				}
			}
		}
		return Math.max(result, max);
	}

}
