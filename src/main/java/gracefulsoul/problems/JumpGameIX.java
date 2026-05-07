package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class JumpGameIX {

	// https://leetcode.com/problems/jump-game-ix/submissions/1997284736/
	public static void main(String[] args) {
		JumpGameIX test = new JumpGameIX();
		PrintUtil.print(test.maxValue(new int[] { 2, 1, 3 }));
		PrintUtil.print(test.maxValue(new int[] { 2, 3, 1 }));
	}

	public int[] maxValue(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return new int[0];
		}
		int[] prefix = new int[length];
		prefix[0] = nums[0];
		for (int i = 1; i < length; i++) {
			prefix[i] = Math.max(nums[i], prefix[i - 1]);
		}
		int[] suffix = new int[length];
		suffix[length - 1] = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			suffix[i] = Math.min(nums[i], suffix[i + 1]);
		}
		int[] result = new int[length];
		result[length - 1] = prefix[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			result[i] = prefix[i];
			if (prefix[i] > suffix[i + 1]) {
				result[i] = result[i + 1];
			}
		}
		return result;
	}

}
