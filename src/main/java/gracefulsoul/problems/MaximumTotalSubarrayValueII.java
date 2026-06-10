package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.object.table.sparse.SparseTable;

public class MaximumTotalSubarrayValueII {

	// https://leetcode.com/problems/maximum-total-subarray-value-ii/submissions/2028509374/
	public static void main(String[] args) {
		MaximumTotalSubarrayValueI test = new MaximumTotalSubarrayValueI();
		System.out.println(test.maxTotalValue(new int[] { 1, 3, 2 }, 2));
		System.out.println(test.maxTotalValue(new int[] { 4, 2, 5, 1 }, 3));
	}

	public long maxTotalValue(int[] nums, int k) {
		int length = nums.length;
		SparseTable sparseTable = new SparseTable(nums);
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (int i = 0; i < length; i++) {
			queue.add(new int[] { sparseTable.query(i, length), i, length });
		}
		long result = 0;
		while (queue.peek()[0] > 0) {
			int[] curr = queue.poll();
			result += curr[0];
			curr[0] = sparseTable.query(curr[1], --curr[2]);
			queue.add(curr);
			if (--k <= 0) {
				break;
			}
		}
		return result;
	}

}
