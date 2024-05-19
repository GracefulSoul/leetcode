package gracefulsoul.problems;

public class FindTheMaximumSumOfNodeValues {

	// https://leetcode.com/problems/find-the-maximum-sum-of-node-values/submissions/1261791228/
	public static void main(String[] args) {
		FindTheMaximumSumOfNodeValues test = new FindTheMaximumSumOfNodeValues();
		System.out.println(test.maximumValueSum(new int[] { 1, 2, 1 }, 3, new int[][] {
			{ 0, 1 },
			{ 0, 2 }
		}));
		System.out.println(test.maximumValueSum(new int[] { 2, 3 }, 7, new int[][] {
			{ 0, 1 }
		}));
		System.out.println(test.maximumValueSum(new int[] { 7, 7, 7, 7, 7, 7 }, 7, new int[][] {
			{ 0, 1 },
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 1 },
			{ 0, 2 }
		}));
	}

	public long maximumValueSum(int[] nums, int k, int[][] edges) {
		long result = 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			result += num;
			int value = (num ^ k) - num;
			if (value > 0) {
				min = Math.min(min, value);
				result += value;
				count++;
			} else {
				max = Math.max(max, value);
			}
		}
		if (count % 2 == 0) {
			return result;
		} else {
			return Math.max(result - min, result + max);
		}
	}

}
