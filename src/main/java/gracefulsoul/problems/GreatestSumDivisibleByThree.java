package gracefulsoul.problems;

import java.util.Arrays;

public class GreatestSumDivisibleByThree {

	// https://leetcode.com/problems/greatest-sum-divisible-by-three/submissions/1611252625/
	public static void main(String[] args) {
		GreatestSumDivisibleByThree test = new GreatestSumDivisibleByThree();
		System.out.println(test.maxSumDivThree(new int[] { 3, 6, 5, 1, 8 }));
		System.out.println(test.maxSumDivThree(new int[] { 4 }));
		System.out.println(test.maxSumDivThree(new int[] { 1, 2, 3, 4, 4 }));
	}

	public int maxSumDivThree(int[] nums) {
		int[] dp = new int[3];
		for (int num : nums) {
			for (int i : Arrays.copyOf(dp, dp.length)) {
				int sum = i + num;
				int remainder = sum % 3;
				dp[remainder] = Math.max(dp[remainder], sum);
			}
		}
		return dp[0];
	}

}
