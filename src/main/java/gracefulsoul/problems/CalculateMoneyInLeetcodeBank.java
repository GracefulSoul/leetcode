package gracefulsoul.problems;

public class CalculateMoneyInLeetcodeBank {

	// https://leetcode.com/problems/calculate-money-in-leetcode-bank/submissions/1113534355/
	public static void main(String[] args) {
		CalculateMoneyInLeetcodeBank test = new CalculateMoneyInLeetcodeBank();
		System.out.println(test.totalMoney(4));
		System.out.println(test.totalMoney(10));
		System.out.println(test.totalMoney(20));
	}

	public int totalMoney(int n) {
		int quotient = n / 7;
		int remainder = n % 7;
		return ((28 + remainder) * quotient)
				+ (((quotient * (quotient - 1)) / 2) * 7)
				+ ((remainder * (remainder + 1)) / 2);
	}

}
