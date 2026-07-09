package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class PathExistenceQueriesInAGraphI {

	// https://leetcode.com/problems/path-existence-queries-in-a-graph-i/submissions/2061757349/
	public static void main(String[] args) {
		PathExistenceQueriesInAGraphI test = new PathExistenceQueriesInAGraphI();
		PrintUtil.print(test.pathExistenceQueries(2, new int[] { 1, 3 }, 1, new int[][] {
			{ 0, 0 },
			{ 0, 1 }
		}));
		PrintUtil.print(test.pathExistenceQueries(4, new int[] {2,5,6,8}, 2, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 3 },
			{ 2, 3 }
		}));
	}

	public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
		int[] group = new int[n];
		for (int i = 1; i < n; i++) {
			group[i] = group[i - 1] + (maxDiff < nums[i] - nums[i - 1] ? 1 : 0);
		}
		int length = queries.length;
		boolean[] result = new boolean[length];
		for (int i = 0; i < length; i++) {
			int[] query = queries[i];
			result[i] = group[query[0]] == group[query[1]];
		}
		return result;
	}

}
