package gracefulsoul.problems;

public class FactorialTrailingZeroes {

	// https://leetcode.com/submissions/detail/558846506/
	public static void main(String[] args) {
		FactorialTrailingZeroes test = new FactorialTrailingZeroes();
		System.out.println(test.trailingZeroes(3));
		System.out.println(test.trailingZeroes(5));
		System.out.println(test.trailingZeroes(0));
	}

	public int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			n /= 5;
			count += n;
		}
		return count;
	}

}
