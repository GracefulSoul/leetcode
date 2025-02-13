package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumOperationsToExceedThresholdValueII {

	// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/submissions/1541543065/
	public static void main(String[] args) {
		MinimumOperationsToExceedThresholdValueII test = new MinimumOperationsToExceedThresholdValueII();
		System.out.println(test.minOperations(new int[] { 2, 11, 10, 1, 3 }, 10));
		System.out.println(test.minOperations(new int[] { 1, 1, 2, 4, 9 }, 20));
	}

	public int minOperations(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			if (num < k) {
				queue.add(num);
			}
		}
		int result = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			result++;
			if (queue.isEmpty()) {
				break;
			} else {
				int y = queue.poll();
				long value = 2L * x + y;
				if (value < k) {
					queue.add((int) value);
				}
			}
		}
		return result;
	}

}
