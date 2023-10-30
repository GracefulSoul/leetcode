package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class SortIntegersByTheNumberOf1Bits {

	// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/submissions/1087247278/
	public static void main(String[] args) {
		SortIntegersByTheNumberOf1Bits test = new SortIntegersByTheNumberOf1Bits();
		PrintUtil.print(test.sortByBits(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }));
		PrintUtil.print(test.sortByBits(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 }));
	}

	public int[] sortByBits(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			arr[i] += Integer.bitCount(arr[i]) * 10001;
		}
		Arrays.sort(arr);
		for (int i = 0; i < length; i++) {
			arr[i] %= 10001;
		}
		return arr;
	}

}
