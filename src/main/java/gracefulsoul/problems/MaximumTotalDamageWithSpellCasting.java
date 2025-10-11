package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumTotalDamageWithSpellCasting {

	// https://leetcode.com/problems/maximum-total-damage-with-spell-casting/submissions/1797838158/
	public static void main(String[] args) {
		MaximumTotalDamageWithSpellCasting test = new MaximumTotalDamageWithSpellCasting();
		System.out.println(test.maximumTotalDamage(new int[] { 1, 1, 3, 4 }));
		System.out.println(test.maximumTotalDamage(new int[] { 7, 1, 6, 6 }));
	}

	public long maximumTotalDamage(int[] power) {
		int length = power.length;
		Arrays.sort(power);
		long[] dp = new long[length];
		long max = 0;
		dp[0] = power[0];
		for (int i = 1, j = 0; i < length; i++) {
			if (power[i] == power[i - 1]) {
				dp[i] = dp[i - 1] + power[i];
			} else {
				while (power[j] + 2 < power[i]) {
					max = Math.max(max, dp[j++]);
				}
				dp[i] = max + power[i];
			}
		}
		long result = 0;
		for (long num : dp) {
			result = Math.max(result, num);
		}
		return result;
	}

}
