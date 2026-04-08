package gracefulsoul.problems;

public class XORAfterRangeMultiplicationQueriesI {

	// https://leetcode.com/problems/xor-after-range-multiplication-queries-i/submissions/1972489468/
	public static void main(String[] args) {
		XORAfterRangeMultiplicationQueriesI test = new XORAfterRangeMultiplicationQueriesI();
		System.out.println(test.xorAfterQueries(new int[] { 1, 1, 1 }, new int[][] {
			{ 0, 2, 1, 4 }
		}));
		System.out.println(test.xorAfterQueries(new int[] { 2, 3, 1, 5, 4}, new int[][] {
			{ 1, 4, 2, 3 },
			{ 0, 2, 1, 2 }
		}));
	}

	public int xorAfterQueries(int[] nums, int[][] queries) {
		for (int[] query : queries) {
			int index = query[0];
			while (index <= query[1]) {
				nums[index] = (int) ((((long) nums[index]) * query[3]) % 1000000007);
				index += query[2];
			}
		}
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

}
