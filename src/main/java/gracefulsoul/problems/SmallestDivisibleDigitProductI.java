package gracefulsoul.problems;

public class SmallestDivisibleDigitProductI {

	// https://leetcode.com/problems/smallest-divisible-digit-product-i/submissions/2096549939/
	public static void main(String[] args) {
		SmallestDivisibleDigitProductI test = new SmallestDivisibleDigitProductI();
		System.out.println(test.smallestNumber(10, 2));
		System.out.println(test.smallestNumber(15, 3));
	}

	public int smallestNumber(int n, int t) {
		while (this.getProduct(n) % t != 0) {
			n++;
		}
		return n;
	}

	private int getProduct(int num) {
		int product = 1;
		while (num != 0) {
			product *= num % 10;
			num /= 10;
		}
		return product;
	}

}
