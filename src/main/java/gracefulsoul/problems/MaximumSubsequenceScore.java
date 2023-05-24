package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSubsequenceScore {

	// https://leetcode.com/problems/maximum-subsequence-score/submissions/956394327/
	public static void main(String[] args) {
		MaximumSubsequenceScore test = new MaximumSubsequenceScore();
		System.out.println(test.maxScore(new int[] { 1, 3, 3, 2 }, new int[] { 2, 1, 3, 4 }, 3));
		System.out.println(test.maxScore(new int[] { 4, 2, 3, 1, 1 }, new int[] { 7, 5, 10, 9, 6 }, 1));

	}

	public long maxScore(int[] nums1, int[] nums2, int k) {
		int length = nums1.length;
		int[][] pairs = new int[length][2];
		for (int i = 0; i < length; i++) {
			pairs[i] = new int[] { nums1[i], nums2[i] };
		}
		Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
		Queue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
		long result = 0;
		long sum = 0;
		for (int[] pair : pairs) {
			queue.offer(pair[0]);
			sum += pair[0];
			if (queue.size() > k) {
				sum -= queue.poll();
			}
			if (queue.size() == k) {
				result = Math.max(result, sum * pair[1]);
			}
		}
		return result;
	}

}
