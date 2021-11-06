package gracefulsoul.problems;

public class PowerOfTwo {

	// https://leetcode.com/submissions/detail/582720692/
	public static void main(String[] args) {
		PowerOfTwo test = new PowerOfTwo();
		System.out.println(test.isPowerOfTwo(1));
		System.out.println(test.isPowerOfTwo(16));
		System.out.println(test.isPowerOfTwo(3));
		System.out.println(test.isPowerOfTwo(4));
		System.out.println(test.isPowerOfTwo(5));
	}

	public boolean isPowerOfTwo(int n) {
		while (n > 1) {
			if (n % 2 == 1) {
				return false;
			}
			n /= 2;
		}
		return n == 1;
	}

}
