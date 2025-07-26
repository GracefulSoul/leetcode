package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class MaximizeSubarraysAfterRemovingOneConflictingPair {

	// https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/submissions/1711599520/
	public static void main(String[] args) {
		MaximizeSubarraysAfterRemovingOneConflictingPair test = new MaximizeSubarraysAfterRemovingOneConflictingPair();
		System.out.println(test.maxSubarrays(4, new int[][] {
			{ 2, 3 },
			{ 1, 4 }
		}));
		System.out.println(test.maxSubarrays(5, new int[][] {
			{ 1, 2 },
			{ 2, 5 },
			{ 3, 5 }
		}));
	}

	@SuppressWarnings("unchecked")
	public long maxSubarrays(int n, int[][] conflictingPairs) {
		List<Integer>[] right = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			right[i] = new ArrayList<>();
		}
		for (int[] pair : conflictingPairs) {
			right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
		}
		long result = 0;
		long[] left = { 0, 0 };
		long[] sum = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int value : right[i]) {
				if (value > left[0]) {
					left[1] = left[0];
					left[0] = value;
				} else if (value > left[1]) {
					left[1] = value;
				}
			}
			result += i - left[0];
			if (left[0] > 0) {
				sum[(int) left[0]] += left[0] - left[1];
			}
		}
		long max = 0;
		for (long num : sum) {
			max = Math.max(max, num);
		}
		return result + max;
	}

}
