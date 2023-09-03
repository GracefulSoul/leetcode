package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SumOfEvenNumbersAfterQueries {

	// https://leetcode.com/problems/sum-of-even-numbers-after-queries/submissions/1038968032/
	public static void main(String[] args) {
		SumOfEvenNumbersAfterQueries test = new SumOfEvenNumbersAfterQueries();
		PrintUtil.print(test.sumEvenAfterQueries(new int[] { 1, 2, 3, 4 }, new int[][] {
			{ 1, 0 },
			{ -3, 1 },
			{ -4, 0 },
			{ 2, 3 }
		}));
		PrintUtil.print(test.sumEvenAfterQueries(new int[] { 1 }, new int[][] {
			{ 4, 0 }
		}));
	}

	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
		int sum = 0;
		for (int num : nums) {
			if (num % 2 == 0) {
				sum += num;
			}
		}
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			if (nums[query[1]] % 2 == 0) {
				sum -= nums[query[1]];
			}
			nums[query[1]] += query[0];
			if (nums[query[1]] % 2 == 0) {
				sum += nums[query[1]];
			}
			result[i] = sum;
		}
		return result;
	}

}
