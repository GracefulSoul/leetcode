package gracefulsoul.problems;

public class CountGoodNumbers {

	// https://leetcode.com/problems/count-good-numbers/submissions/1605070658/
	public static void main(String[] args) {
		CountGoodNumbers test = new CountGoodNumbers();
		System.out.println(test.countGoodNumbers(1));
		System.out.println(test.countGoodNumbers(4));
		System.out.println(test.countGoodNumbers(50));
	}

	private static final int MOD = 1000000007;

	public int countGoodNumbers(long n) {
		return (int) (this.pow(5, (n + 1) / 2) * this.pow(4, n / 2) % MOD);
	}

	public long pow(long x, long y) {
		if (y == 0) {
			return 1;
		} else {
			long temp = this.pow(x, y / 2);
			if (y % 2 == 0) {
				return (temp * temp) % MOD;
			} else {
				return (x * temp * temp) % MOD;
			}
		}
	}

}
