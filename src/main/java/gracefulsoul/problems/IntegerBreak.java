package gracefulsoul.problems;

public class IntegerBreak {

	// https://leetcode.com/submissions/detail/622218420/
	public static void main(String[] args) {
		IntegerBreak test = new IntegerBreak();
		System.out.println(test.integerBreak(2));
		System.out.println(test.integerBreak(10));
	}

	public int integerBreak(int n) {
		if (n <= 3) {
			return n - 1;
		} else {
			int product = 1;
			while (n > 4) {
				product *= 3;
				n -= 3;
			}
			return product * n;
		}
	}

}
