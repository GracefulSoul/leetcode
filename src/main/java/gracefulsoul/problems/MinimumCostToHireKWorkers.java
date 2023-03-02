package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToHireKWorkers {

	// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/submissions/907659494/
	public static void main(String[] args) {
		MinimumCostToHireKWorkers test = new MinimumCostToHireKWorkers();
		System.out.println(test.mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2));
		System.out.println(test.mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3));
	}

	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		int length = quality.length;
		Integer[] id = new Integer[length];
		for (int i = 0; i < length; i++) {
			id[i] = i;
		}
		Arrays.sort(id, (i, j) -> (wage[i] * quality[j]) - (wage[j] * quality[i]));
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		int sum = 0;
		for (int i = 0; i < k; i++) {
			queue.offer(quality[id[i]]);
			sum += quality[id[i]];
		}
		double result = sum * ((double) wage[id[k - 1]] / quality[id[k - 1]]);
		for (int i = k; i < length; i++) {
			int q = quality[id[i]];
			if (q < queue.peek()) {
				sum -= queue.poll() - q;
				queue.offer(q);
				result = Math.min(result, sum * ((double) wage[id[i]] / q));
			}
		}
		return result;
	}

}
