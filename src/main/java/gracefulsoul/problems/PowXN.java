package gracefulsoul.problems;

public class PowXN {

	// https://leetcode.com/submissions/detail/501342931/
	public static void main(String[] args) {
		PowXN test = new PowXN();
		System.out.println(test.myPow(2.00000d, 10));
		System.out.println(test.myPow(2.10000d, 3));
		System.out.println(test.myPow(2.00000d, -2));
	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == Integer.MIN_VALUE) {
			x *= x;
			n /= 2;
		}
		if (n < 0) {
			x = 1 / x;
			n *= -1;
		}
		return (n % 2 == 0 ? 1 : x) * this.myPow(x * x, n / 2);
	}

}