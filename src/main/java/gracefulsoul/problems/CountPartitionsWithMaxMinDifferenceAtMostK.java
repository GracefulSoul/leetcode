package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountPartitionsWithMaxMinDifferenceAtMostK {

	// https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/submissions/1848033462/
	public static void main(String[] args) {
		CountPartitionsWithMaxMinDifferenceAtMostK test = new CountPartitionsWithMaxMinDifferenceAtMostK();
		System.out.println(test.countPartitions(new int[] { 9, 4, 1, 3, 7 }, 4));
		System.out.println(test.countPartitions(new int[] { 3, 3, 4 }, 0));
	}

	public int countPartitions(int[] nums, int k) {
		int mod = 1000000007;
		int length = nums.length;
		int count = 1;
		int[] dp = new int[length + 1];
		dp[0] = 1;
		Deque<Integer> minDeque = new ArrayDeque<>();
		Deque<Integer> maxDeque = new ArrayDeque<>();
		for (int i = 0, j = 0; j < length; j++) {
			while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[j]) {
				maxDeque.pollLast();
			}
			maxDeque.addLast(j);
			while (!minDeque.isEmpty() && nums[j] < nums[minDeque.peekLast()]) {
				minDeque.pollLast();
			}
			minDeque.addLast(j);
			while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
				count = (count - dp[i++] + mod) % mod;
				if (minDeque.peekFirst() < i) {
					minDeque.pollFirst();
				}
				if (maxDeque.peekFirst() < i) {
					maxDeque.pollFirst();
				}
			}
			dp[j + 1] = count;
			count = (count + dp[j + 1]) % mod;
		}
		return dp[length];
	}

}
