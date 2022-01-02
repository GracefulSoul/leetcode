package gracefulsoul.problems;

public class PowerOfThree {

	// https://leetcode.com/submissions/detail/611436813/
	public static void main(String[] args) {
		PowerOfThree test = new PowerOfThree();
		System.out.println(test.isPowerOfThree(27));
		System.out.println(test.isPowerOfThree(0));
		System.out.println(test.isPowerOfThree(9));
	}

	public boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

}
