package gracefulsoul.problems;

public class CountNumbersWithUniqueDigits {

	// https://leetcode.com/submissions/detail/628744530/
	public static void main(String[] args) {
		CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();
		System.out.println(test.countNumbersWithUniqueDigits(2));
		System.out.println(test.countNumbersWithUniqueDigits(0));
	}

	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		} else {
			int count = 10;
			int unit = 9;
			for (int idx = 2; idx <= n && idx <= 10; idx++) {
				unit *= 9 - idx + 2;
				count += unit;
			}
			return count;
		}
	}

}
