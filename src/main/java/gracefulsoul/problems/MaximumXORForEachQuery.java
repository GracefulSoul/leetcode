package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MaximumXORForEachQuery {

	// https://leetcode.com/problems/maximum-xor-for-each-query/submissions/1446595893/
	public static void main(String[] args) {
		MaximumXORForEachQuery test = new MaximumXORForEachQuery();
		PrintUtil.print(test.getMaximumXor(new int[] { 0, 1, 1, 3 }, 2));
		PrintUtil.print(test.getMaximumXor(new int[] { 2, 3, 4, 7 }, 3));
		PrintUtil.print(test.getMaximumXor(new int[] { 0, 1, 2, 2, 5, 7 }, 3));
	}

	public int[] getMaximumXor(int[] nums, int maximumBit) {
		int length = nums.length;
		int[] result = new int[length];
		int num = (1 << maximumBit) - 1;
		for (int i = 0; i < length; i++) {
			num ^= nums[i];
			result[(length - 1) - i] = num;
		}
		return result;
	}

}
