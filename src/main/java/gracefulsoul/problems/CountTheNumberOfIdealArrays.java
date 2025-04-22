package gracefulsoul.problems;

import java.math.BigInteger;

public class CountTheNumberOfIdealArrays {

	// https://leetcode.com/problems/count-the-number-of-ideal-arrays/submissions/1614519797/
	public static void main(String[] args) {
		CountTheNumberOfIdealArrays test = new CountTheNumberOfIdealArrays();
		System.out.println(test.idealArrays(2, 5));
		System.out.println(test.idealArrays(5, 3));
	}

	private static final int MOD = 1000000007;

	public int idealArrays(int n, int maxValue) {
		int[] min = new int[maxValue + 1];
		for (int i = 2; i <= maxValue; i++) {
			if (min[i] != 0) {
				continue;
			}
			for (int j = i; j <= maxValue; j += i) {
				if (min[j] == 0) {
					min[j] = i;
				}
			}
		}
		int max = (int) (Math.log(maxValue) / Math.log(2));
		int[] dp = new int[max + 1];
		BigInteger bi = BigInteger.ONE;
		BigInteger biMod = BigInteger.valueOf(MOD);
		for (int i = 1; i <= max; i++) {
			bi = bi.multiply(BigInteger.valueOf(n + i - 1));
			bi = bi.divide(BigInteger.valueOf(i));
			dp[i] = bi.mod(biMod).intValue();
		}
		int result = 0;
		for (int i = 1; i <= maxValue; i++) {
			int index = i;
			long temp = 1;
			while (index > 1) {
				int curr = min[index];
				int count = 0;
				while (index % curr == 0) {
					count++;
					index /= curr;
				}
				temp = (temp * dp[count]) % MOD;
			}
			result = (result + (int) temp) % MOD;
		}
		return result;
	}

}
