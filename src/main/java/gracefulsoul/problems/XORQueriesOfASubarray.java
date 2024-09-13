package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class XORQueriesOfASubarray {

	// https://leetcode.com/problems/xor-queries-of-a-subarray/submissions/1388285611/
	public static void main(String[] args) {
		XORQueriesOfASubarray test = new XORQueriesOfASubarray();
		PrintUtil.print(test.xorQueries(new int[] { 1, 3, 4, 8 }, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 0, 3 },
			{ 3, 3 }
		}));
		PrintUtil.print(test.xorQueries(new int[] { 4, 8, 2, 10 }, new int[][] {
			{ 2, 3 },
			{ 1, 3 },
			{ 0, 0 },
			{ 0, 3 }
		}));
	}

	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];
		for (int i = 1; i < arr.length; i++) {
			arr[i] ^= arr[i - 1];
		}
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			result[i] = query[0] > 0 ? arr[query[0] - 1] ^ arr[query[1]] : arr[query[1]];
		}
		return result;
	}

}
