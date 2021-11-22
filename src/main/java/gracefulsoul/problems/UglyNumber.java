package gracefulsoul.problems;

public class UglyNumber {

	// https://leetcode.com/submissions/detail/590743583/
	public static void main(String[] args) {
		UglyNumber test = new UglyNumber();
		System.out.println(test.isUgly(6));
		System.out.println(test.isUgly(8));
		System.out.println(test.isUgly(14));
		System.out.println(test.isUgly(1));
	}

	public boolean isUgly(int n) {
		for (int i = 2; i < 6 && n > 0; i++) {
			while (i != 4 && n % i == 0) {
				n /= i;
			}
		}
		return n == 1;
	}

}
