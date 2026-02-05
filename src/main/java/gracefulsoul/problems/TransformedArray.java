package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class TransformedArray {

	// https://leetcode.com/problems/transformed-array/submissions/1909100543/
	public static void main(String[] args) {
		TransformedArray test = new TransformedArray();
		PrintUtil.print(test.constructTransformedArray(new int[] { 3, -2, 1, 1 }));
		PrintUtil.print(test.constructTransformedArray(new int[] { -1, 4, -1 }));
	}

	public int[] constructTransformedArray(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = nums[(((i + nums[i]) % length) + length) % length];
		}
		return result;
	}

}
