package gracefulsoul.problems;

import java.util.Arrays;

public class ContiguousArray {

	// https://leetcode.com/submissions/detail/719242276/
	public static void main(String[] args) {
		ContiguousArray test = new ContiguousArray();
		System.out.println(test.findMaxLength(new int[] { 0, 1 }));
		System.out.println(test.findMaxLength(new int[] { 0, 1, 0 }));
	}

	public int findMaxLength(int[] nums) {
		int[] dp = new int[2 * nums.length + 1];
		Arrays.fill(dp, -2);
		dp[nums.length] = -1;
		int result = 0;
		int count = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			count += nums[idx] == 0 ? -1 : 1;
			if (dp[count + nums.length] >= -1) {
				result = Math.max(result, idx - dp[count + nums.length]);
			} else {
				dp[count + nums.length] = idx;
			}
		}
		return result;
	}

}
