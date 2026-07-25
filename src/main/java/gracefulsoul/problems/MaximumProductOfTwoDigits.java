package gracefulsoul.problems;

public class MaximumProductOfTwoDigits {

	// https://leetcode.com/problems/maximum-product-of-two-digits/submissions/2080149452/
	public static void main(String[] args) {
		MaximumProductOfTwoDigits test = new MaximumProductOfTwoDigits();
		System.out.println(test.maxProduct(31));
		System.out.println(test.maxProduct(22));
		System.out.println(test.maxProduct(124));
	}

	public int maxProduct(int n) {
		int[] max = new int[2];
		while (0 < n) {
			int num = n % 10;
			if (max[0] < num) {
				max[1] = max[0];
				max[0] = num;
			} else if (max[1] < num) {
				max[1] = num;
			}
			n /= 10;
		}
		return max[0] * max[1];
	}

}
