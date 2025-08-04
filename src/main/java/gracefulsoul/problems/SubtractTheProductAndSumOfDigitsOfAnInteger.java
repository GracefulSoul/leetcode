package gracefulsoul.problems;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {

	// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/submissions/1722878217/
	public static void main(String[] args) {
		SubtractTheProductAndSumOfDigitsOfAnInteger test = new SubtractTheProductAndSumOfDigitsOfAnInteger();
		System.out.println(test.subtractProductAndSum(234));
		System.out.println(test.subtractProductAndSum(4421));
	}

	public int subtractProductAndSum(int n) {
		int substract = 1;
		int sum = 0;
		while (n > 0) {
			int remainder = n % 10;
			n /= 10;
			substract *= remainder;
			sum += remainder;
		}
		return substract - sum;
	}

}
