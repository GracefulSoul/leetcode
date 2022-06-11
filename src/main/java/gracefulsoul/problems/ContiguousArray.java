package gracefulsoul.problems;

import java.util.Arrays;

public class ContiguousArray {

	// https://leetcode.com/submissions/detail/719265380/
	public static void main(String[] args) {
		ContiguousArray test = new ContiguousArray();
		System.out.println(test.findMaxLength(new int[] { 0, 1 }));
		System.out.println(test.findMaxLength(new int[] { 0, 1, 0 }));
	}

	public int findMaxLength(int[] nums) {
		int length = nums.length;
		int[] dp = new int[2 * length + 1];
		Arrays.fill(dp, -2);
		dp[length] = -1;
		int result = 0;
		int index = length;
		for (int idx = 0; idx < length; idx++) {
			index += nums[idx] == 0 ? -1 : 1;
			if (dp[index] >= -1) {
				result = Math.max(result, idx - dp[index]);
			} else {
				dp[index] = idx;
			}
		}
		return result;
	}

}
