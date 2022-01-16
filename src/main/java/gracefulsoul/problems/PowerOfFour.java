package gracefulsoul.problems;

public class PowerOfFour {

	// https://leetcode.com/submissions/detail/620822861/
	public static void main(String[] args) {
		PowerOfFour test = new PowerOfFour();
		System.out.println(test.isPowerOfFour(16));
		System.out.println(test.isPowerOfFour(5));
		System.out.println(test.isPowerOfFour(1));
	}

	public boolean isPowerOfFour(int n) {
		if ((n & (n - 1)) == 0) {
			while (n > 1) {
				n >>= 2;
			}
		}
		return n == 1;
	}

}
