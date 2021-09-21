package gracefulsoul.problems;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		FactorialTrailingZeroes test = new FactorialTrailingZeroes();
		System.out.println(test.trailingZeroes(3));
		System.out.println(test.trailingZeroes(1));
		System.out.println(test.trailingZeroes(0));
	}

	public int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			int temp = n / 5;
			count += temp;
			n = temp;
		}
		return count;
	}

}
