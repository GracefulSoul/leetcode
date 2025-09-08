package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

	// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/submissions/1763635954/
	public static void main(String[] args) {
		ConvertIntegerToTheSumOfTwoNoZeroIntegers test = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();
		PrintUtil.print(test.getNoZeroIntegers(2));
		PrintUtil.print(test.getNoZeroIntegers(11));
	}

	public int[] getNoZeroIntegers(int n) {
		int[] result = new int[] { 0, n };
		while (result[0]++ < result[1]--) {
			if (this.isNoZeroInteger(result[0]) && this.isNoZeroInteger(result[1])) {
				break;
			}
		}
		return result;
	}

	private boolean isNoZeroInteger(int num) {
		while (num >= 1) {
			if (num % 10 == 0) {
				return false;
			}
			num /= 10;
		}
		return true;
	}

}
