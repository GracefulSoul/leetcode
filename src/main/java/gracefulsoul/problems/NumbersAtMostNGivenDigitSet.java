package gracefulsoul.problems;

public class NumbersAtMostNGivenDigitSet {

	// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/submissions/934539451/
	public static void main(String[] args) {
		NumbersAtMostNGivenDigitSet test = new NumbersAtMostNGivenDigitSet();
		System.out.println(test.atMostNGivenDigitSet(new String[] { "1", "3", "5", "7" }, 100));
		System.out.println(test.atMostNGivenDigitSet(new String[] { "1", "4", "9" }, 1000000000));
		System.out.println(test.atMostNGivenDigitSet(new String[] { "7" }, 8));
	}

	public int atMostNGivenDigitSet(String[] digits, int n) {
		String str = String.valueOf(n);
		int length = str.length();
		int[] dp = new int[length + 1];
		dp[length] = 1;
		for (int i = length - 1; i >= 0; i--) {
			int num = str.charAt(i) - '0';
			for (String digit : digits) {
				if (Integer.parseInt(digit) < num) {
					dp[i] += Math.pow(digits.length, length - i - 1);
				} else if (Integer.parseInt(digit) == num) {
					dp[i] += dp[i + 1];
				}
			}
		}
		for (int i = 1; i < length; i++) {
			dp[0] += Math.pow(digits.length, i);
		}
		return dp[0];
	}

}
