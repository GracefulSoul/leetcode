package gracefulsoul.problems;

public class NumberOfZigZagArraysII {

	// https://leetcode.com/problems/number-of-zigzag-arrays-ii/submissions/2044519839/
	public static void main(String[] args) {
		NumberOfZigZagArraysII test = new NumberOfZigZagArraysII();
		System.out.println(test.zigZagArrays(3, 4, 5));
		System.out.println(test.zigZagArrays(3, 1, 3));
	}

	private static final long MOD = 1000000007L;

	public int zigZagArrays(int n, int l, int r) {
		int length = r - l + 1;
		int limit = 2 * length;
		long[][] temp = new long[limit][limit];
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				temp[i][length + j] = 1;
			}
			for (int j = 0; j < i; j++) {
				temp[length + i][j] = 1;
			}
		}
		long[][] dp = new long[limit][limit];
		for (int i = 0; i < limit; i++) {
			dp[i][i] = 1;
		}
		long power = n - 1;
		while (power > 0) {
			if ((power & 1) == 1) {
				dp = this.multiply(dp, temp);
			}
			temp = this.multiply(temp, temp);
			power >>= 1;
		}
		long result = 0;
		for (int i = 0; i < limit; i++) {
			long sum = 0;
			for (int j = 0; j < limit; j++) {
				sum = (sum + dp[i][j]) % MOD;
			}
			result = (result + sum) % MOD;
		}
		return (int) result;
	}

	private long[][] multiply(long[][] a, long[][] b) {
		int length = a.length;
		long[][] dp = new long[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (a[i][j] == 0) {
					continue;
				}
				long curr = a[i][j];
				for (int k = 0; k < length; k++) {
					if (b[j][k] == 0) {
						continue;
					}
					dp[i][k] = (dp[i][k] + (curr * b[j][k])) % MOD;
				}
			}
		}
		return dp;
	}

}
