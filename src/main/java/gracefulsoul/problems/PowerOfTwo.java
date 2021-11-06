package gracefulsoul.problems;

public class PowerOfTwo {

	// https://leetcode.com/submissions/detail/582724711/
	public static void main(String[] args) {
		PowerOfTwo test = new PowerOfTwo();
		System.out.println(test.isPowerOfTwo(1));
		System.out.println(test.isPowerOfTwo(16));
		System.out.println(test.isPowerOfTwo(3));
		System.out.println(test.isPowerOfTwo(4));
		System.out.println(test.isPowerOfTwo(5));
	}

	public boolean isPowerOfTwo(int n) {
		if (n > 0) {
			return (n & (n - 1)) == 0;
		} else {
			return false;
		}
	}

}
