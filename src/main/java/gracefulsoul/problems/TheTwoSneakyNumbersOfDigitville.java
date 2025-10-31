package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class TheTwoSneakyNumbersOfDigitville {

	// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/submissions/1816689815/
	public static void main(String[] args) {
		TheTwoSneakyNumbersOfDigitville test = new TheTwoSneakyNumbersOfDigitville();
		PrintUtil.print(test.getSneakyNumbers(new int[] { 0, 1, 1, 0 }));
		PrintUtil.print(test.getSneakyNumbers(new int[] { 0, 3, 2, 1, 3, 2 }));
		PrintUtil.print(test.getSneakyNumbers(new int[] { 7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2 }));
	}

	public int[] getSneakyNumbers(int[] nums) {
		int n = nums.length - 2;
		int max = 0;
		int count = 0;
		int[] counts = new int[n];
		for (int num : nums) {
			if (max < ++counts[num]) {
				count = 1;
				max = counts[num];
			} else if (max == counts[num]) {
				count++;
			}
		}
		int index = 0;
		int[] result = new int[count];
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == max) {
				result[index++] = i;
			}
		}
		return result;
	}

}
