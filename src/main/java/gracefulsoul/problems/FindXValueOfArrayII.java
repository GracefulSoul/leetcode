package gracefulsoul.problems;

import gracefulsoul.object.tree.mod.SegmentTree;
import gracefulsoul.util.PrintUtil;

public class FindXValueOfArrayII {

	// https://leetcode.com/problems/find-x-value-of-array-ii/submissions/2149735584/
	public static void main(String[] args) {
		FindXValueOfArrayII test = new FindXValueOfArrayII();
		PrintUtil.print(test.resultArray(new int[] { 1, 2, 3, 4, 5 }, 3, new int[][] {
			{ 2, 2, 0, 2 },
			{ 3, 3, 3, 0 },
			{ 0, 1, 0, 1 }
		}));
		PrintUtil.print(
				test.resultArray(new int[] { 1, 2, 4, 8, 16, 32 }, 4, new int[][] {
			{ 0, 2, 0, 2 },
			{ 0, 2, 0, 1 }
		}));
		PrintUtil.print(test.resultArray(new int[] { 1, 1, 2, 1, 1 }, 2, new int[][] {
			{ 2, 1, 0, 1 }
		}));
	}

	public int[] resultArray(int[] nums, int k, int[][] queries) {
		int queriesLength = queries.length;
		int numsLength = nums.length;
		SegmentTree tree = new SegmentTree(nums, k);
		int[] result = new int[queriesLength];
		for (int i = 0; i < queriesLength; i++) {
			int[] query = queries[i];
			tree.update(query[0], query[1]);
			result[i] = tree.query(query[2], numsLength).getWays()[query[3]];
		}
		return result;
	}

}
