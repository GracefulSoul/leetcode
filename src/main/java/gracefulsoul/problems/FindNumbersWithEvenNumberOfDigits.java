package gracefulsoul.problems;

public class FindNumbersWithEvenNumberOfDigits {

	// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/1622352368/
	public static void main(String[] args) {
		FindNumbersWithEvenNumberOfDigits test = new FindNumbersWithEvenNumberOfDigits();
		System.out.println(test.findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
		System.out.println(test.findNumbers(new int[] { 555, 901, 482, 1771 }));
	}

	public int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			if ((9 < num && num < 100) || (999 < num && num < 10000) || num == 100000) {
				count++;
			}
		}
		return count;
	}

}
