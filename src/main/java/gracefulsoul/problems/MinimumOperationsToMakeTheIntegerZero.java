package gracefulsoul.problems;

public class MinimumOperationsToMakeTheIntegerZero {

	// https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/submissions/1760303077/
	public static void main(String[] args) {
		MinimumOperationsToMakeTheIntegerZero test = new MinimumOperationsToMakeTheIntegerZero();
		System.out.println(test.makeTheIntegerZero(3, -2));
		System.out.println(test.makeTheIntegerZero(5, 7));
	}

	public int makeTheIntegerZero(int num1, int num2) {
		for (int i = 1; i <= 60; i++) {
			long num = num1 - ((long) num2 * i);
			if (num < i) {
				return -1;
			}
			if (Long.bitCount(num) <= i) {
				return i;
			}
		}
		return -1;
	}

}
