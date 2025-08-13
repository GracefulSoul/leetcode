package gracefulsoul.problems;

public class PowerOfThree {

	// https://leetcode.com/submissions/detail/1733532865/
	public static void main(String[] args) {
		PowerOfThree test = new PowerOfThree();
		System.out.println(test.isPowerOfThree(27));
		System.out.println(test.isPowerOfThree(0));
		System.out.println(test.isPowerOfThree(9));
	}

	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		} else {
			while (n % 3 == 0) {
				n /= 3;
			}
			return n == 1;
		}
	}

}
