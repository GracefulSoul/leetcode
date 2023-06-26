package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireKWorkers {

	// https://leetcode.com/problems/total-cost-to-hire-k-workers/submissions/979933492/
	public static void main(String[] args) {
		TotalCostToHireKWorkers test = new TotalCostToHireKWorkers();
		System.out.println(test.totalCost(new int[] { 17, 12, 10, 2, 7, 2, 11, 20, 8 }, 3, 4));
		System.out.println(test.totalCost(new int[] { 1, 2, 4, 1 }, 3, 3));
	}

	public long totalCost(int[] costs, int k, int candidates) {
		long result = 0;
		if (candidates * 2 > costs.length - k || costs.length == k) {
			Arrays.sort(costs);
			for (int i = 0; i < k; i++) {
				result += costs[i];
			}
			return result;
		}
		int left = 0;
		int right = costs.length - 1;
		Queue<Integer> queue1 = new PriorityQueue<>();
		Queue<Integer> queue2 = new PriorityQueue<>();
		while (queue1.size() < candidates && left <= right) {
			queue1.offer(costs[left++]);
			queue2.offer(costs[right--]);
		}
		while (k-- > 0) {
			if (queue1.peek() <= queue2.peek()) {
				result += queue1.poll();
				queue1.offer(costs[left++]);
			} else {
				result += queue2.poll();
				queue2.offer(costs[right--]);
			}
		}
		return result;
	}

}
