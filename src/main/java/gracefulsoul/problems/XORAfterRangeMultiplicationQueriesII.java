package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class XORAfterRangeMultiplicationQueriesII {

	// https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/submissions/1973458291/
	public static void main(String[] args) {
		XORAfterRangeMultiplicationQueriesII test = new XORAfterRangeMultiplicationQueriesII();
		System.out.println(test.xorAfterQueries(new int[] { 1, 1, 1 }, new int[][] {
			{ 0, 2, 1, 4 }
		}));
		System.out.println(test.xorAfterQueries(new int[] { 2, 3, 1, 5, 4}, new int[][] {
			{ 1, 4, 2, 3 },
			{ 0, 2, 1, 2 }
		}));
	}

	private static final int MOD = 1000000007;

	@SuppressWarnings("unchecked")
	public int xorAfterQueries(int[] nums, int[][] queries) {
		int length = nums.length;
		int sqrt = (int) Math.sqrt(length);
		ArrayList<int[]>[][] store = new ArrayList[sqrt + 1][sqrt + 1];
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++) {
				store[i][j] = new ArrayList<>();
			}
		}
		for (int[] query : queries) {
			if (query[2] >= sqrt) {
				for (int i = query[0]; i <= query[1]; i += query[2]) {
					nums[i] = (int) ((1L * nums[i] * query[3]) % MOD);
				}
			} else {
				store[query[2]][query[0] % query[2]].add(new int[] { query[0], query[1], query[3] });
			}
		}
		for (int k = 1; k < sqrt; k++) {
			for (int rem = 0; rem < k; rem++) {
				if (store[k][rem].isEmpty()) {
					continue;
				}
				ArrayList<int[]> list = store[k][rem];
				int chainLength = (length - rem + k - 1) / k;
				long[] diff = new long[chainLength + 1];
				Arrays.fill(diff, 1L);
				for (int[] arr : list) {
					int start = (arr[0] - rem) / k;
					int end = (arr[1] - rem) / k;
					if (start < 0) {
						start = 0;
					}
					if (end >= chainLength) {
						end = chainLength - 1;
					}
					if (start > end) {
						continue;
					}
					diff[start] = (diff[start] * arr[2]) % MOD;
					if (end + 1 < chainLength) {
						diff[end + 1] = (diff[end + 1] * this.mod(arr[2])) % MOD;
					}
				}
				long curr = 1L;
				for (int i = 0; i < chainLength; i++) {
					curr = (curr * diff[i]) % MOD;
					int idx = rem + (i * k);
					nums[idx] = (int) ((1L * nums[idx] * curr) % MOD);
				}
			}
		}
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

	private long mod(long num) {
		return this.pow(num, MOD - 2);
	}

	private long pow(long num1, long num2) {
		long result = 1;
		while (num2 > 0) {
			if ((num2 & 1) == 1) {
				result = (result * num1) % MOD;
			}
			num1 = (num1 * num1) % MOD;
			num2 >>= 1;
		}
		return result;
	}

}
