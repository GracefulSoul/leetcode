package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class RangeSumofSortedSubarraySums {

	// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/submissions/1343624486/
	public static void main(String[] args) {
		RangeSumofSortedSubarraySums test = new RangeSumofSortedSubarraySums();
		System.out.println(test.rangeSum(new int[] { 1, 2, 3, 4 }, 4, 1, 5));
		System.out.println(test.rangeSum(new int[] { 1, 2, 3, 4 }, 4, 3, 4));
		System.out.println(test.rangeSum(new int[] { 1, 2, 3, 4 }, 4, 1, 10));
	}

	public int rangeSum(int[] nums, int n, int left, int right) {
		int mod = 1000000007;
		int length = nums.length;
		int result = 0;
		Queue<int[]> queue = new PriorityQueue<int[]>(length, (p1, p2) -> p1[0] - p2[0]);
		for (int i = 0; i < length; i++) {
			queue.offer(new int[] { nums[i], i });
		}
		for (int i = 1; i <= right; i++) {
			int[] pair = queue.poll();
			if (i >= left) {
				result = (result + pair[0]) % mod;
			}
			if (pair[1] < length - 1) {
				pair[1]++;
				pair[0] = (pair[0] % mod + nums[pair[1]] % mod) % mod;
				queue.offer(new int[] { pair[0], pair[1] });
			}
		}
		return result;
	}

}
