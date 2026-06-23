package gracefulsoul.problems;

import java.util.Arrays;

public class NumberOfZigZagArraysI {

	// https://leetcode.com/problems/number-of-zigzag-arrays-i/submissions/2043339461/
	public static void main(String[] args) {
		NumberOfZigZagArraysI test = new NumberOfZigZagArraysI();
		System.out.println(test.zigZagArrays(3, 4, 5));
		System.out.println(test.zigZagArrays(3, 1, 3));
	}

	private static final int MOD = 1000000007;

	public int zigZagArrays(int n, int l, int r) {
		int length = r - l + 1;
		int[] dp = new int[length];
		Arrays.fill(dp, 1);
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			if ((i & 1) == 0) {
				for (int j = 0; j < length; j++) {
					int t = dp[j];
					dp[j] = sum;
					sum = (sum + t) % MOD;
				}
			} else {
				for (int j = length - 1; j >= 0; j--) {
					int temp = dp[j];
					dp[j] = sum;
					sum = (sum + temp) % MOD;
				}
			}
		}
		int result = 0;
		for (int num : dp) {
			result = (result + num) % MOD;
		}
		return (result << 1) % MOD;
	}

}
