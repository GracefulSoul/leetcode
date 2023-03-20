package gracefulsoul.problems;

public class NthMagicalNumber {

	// https://leetcode.com/problems/nth-magical-number/submissions/918683201/
	public static void main(String[] args) {
		NthMagicalNumber test = new NthMagicalNumber();
		System.out.println(test.nthMagicalNumber(1, 2, 3));
		System.out.println(test.nthMagicalNumber(4, 2, 3));
	}

	public int nthMagicalNumber(int n, int a, int b) {
		long A = a;
		long B = b;
		long mod = 1000000007L;
		long left = Math.min(a, b);
		long right = (long) n * Math.min(a, b);
		while (B > 0) {
			long temp = A;
			A = B;
			B = temp % B;
		}
		long lcm = (a * b) / A;
		while (left < right) {
			long mid = left + (right - left) / 2;
			if ((mid / a) + (mid / b) - (mid / lcm) < n) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return (int) (left % mod);
	}

}
