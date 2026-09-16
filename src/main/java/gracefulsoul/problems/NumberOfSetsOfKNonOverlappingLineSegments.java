package gracefulsoul.problems;

public class NumberOfSetsOfKNonOverlappingLineSegments {

	// https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/submissions/2143612791/
	public static void main(String[] args) {
		NumberOfSetsOfKNonOverlappingLineSegments test = new NumberOfSetsOfKNonOverlappingLineSegments();
		System.out.println(test.numberOfSets(4, 2));
		System.out.println(test.numberOfSets(3, 1));
		System.out.println(test.numberOfSets(30, 7));
		System.out.println(test.numberOfSets(42, 25));
	}

	private static final int MOD = 1000000007;

	public int numberOfSets(int n, int k) {
		int N = n + k - 1;
		int R = 2 * k;
		if (R > N) {
			return 0;
		}
		long num = 1;
		long den = 1;
		for (int i = 0; i < R; i++) {
			num = (num * (N - i)) % MOD;
			den = (den * (i + 1)) % MOD;
		}
		return (int) ((num * this.power(den, MOD - 2)) % MOD);
	}

	private long power(long base, long exp) {
		long result = 1;
		base %= MOD;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = (result * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;
		}
		return result;
	}

}
