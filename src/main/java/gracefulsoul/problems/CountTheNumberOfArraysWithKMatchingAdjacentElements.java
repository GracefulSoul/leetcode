package gracefulsoul.problems;

public class CountTheNumberOfArraysWithKMatchingAdjacentElements {

	// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/submissions/1667074862/
	public static void main(String[] args) {
		CountTheNumberOfArraysWithKMatchingAdjacentElements test = new CountTheNumberOfArraysWithKMatchingAdjacentElements();
		System.out.println(test.countGoodArrays(3, 2, 1));
		System.out.println(test.countGoodArrays(4, 2, 2));
		System.out.println(test.countGoodArrays(5, 2, 0));
	}

	private static final int MOD = 1000000007;
	private final long[] factorial = new long[100001];

	public int countGoodArrays(int n, int m, int k) {
		if (this.factorial[0] == 0) {
			this.factorial[0] = 1;
		}
		return (int) ((((m * this.pow(m - 1L, n - 1 - k)) % MOD) * this.nCr(n - 1, n - 1 - k)) % MOD);
	}

	private long pow(long base, int exp) {
		long result = 1L;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = (result * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;
		}
		return result;
	}

	private long nCr(int n, int r) {
		return (((this.getFactorial(n) * this.getReverse(this.getFactorial(n - r))) % MOD) * this.getReverse(this.getFactorial(r))) % MOD;
	}

	private long getFactorial(int n) {
		if (this.factorial[n] == 0) {
			this.factorial[n] = (int) ((this.getFactorial(n - 1) * n) % MOD);
		}
		return this.factorial[n];
	}

	private long getReverse(long n) {
		if (n == 1) {
			return n;
		} else {
			return MOD - (((MOD / n) * this.getReverse(MOD % n)) % MOD);
		}
	}

}
