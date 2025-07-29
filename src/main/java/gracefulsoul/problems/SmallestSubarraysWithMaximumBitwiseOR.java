package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SmallestSubarraysWithMaximumBitwiseOR {

	// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/submissions/1715695384/
	public static void main(String[] args) {
		SmallestSubarraysWithMaximumBitwiseOR test = new SmallestSubarraysWithMaximumBitwiseOR();
		PrintUtil.print(test.smallestSubarrays(new int[] { 1, 0, 2, 1, 3 }));
		PrintUtil.print(test.smallestSubarrays(new int[] { 1, 2 }));
	}

	public int[] smallestSubarrays(int[] nums) {
		int length = nums.length;
		int[] last = new int[30];
		int[] result = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			result[i] = 1;
			for (int j = 0; j < 30; j++) {
				if ((nums[i] & (1 << j)) > 0) {
					last[j] = i;
				}
				result[i] = Math.max(result[i], last[j] - i + 1);
			}
		}
		return result;
	}

}
