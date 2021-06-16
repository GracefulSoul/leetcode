package gracefulsoul.problems;

import java.util.Arrays;

public class PlusOne {

	// https://leetcode.com/submissions/detail/508719599/
	public static void main(String[] args) {
		PlusOne test = new PlusOne();
		print(test.plusOne(new int[] { 1, 2, 3 }));
		print(test.plusOne(new int[] { 4, 3, 2, 1 }));
	}

	public int[] plusOne(int[] digits) {
		for (int idx = digits.length - 1; idx >= 0; idx--) {
			if (digits[idx] == 9) {
				digits[idx] = 0;
			} else {
				digits[idx]++;
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	public static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}
