package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DuplicateZeros {

	// https://leetcode.com/problems/duplicate-zeros/submissions/1234735196/
	public static void main(String[] args) {
		DuplicateZeros test = new DuplicateZeros();
		int[] arr1 = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
		test.duplicateZeros(arr1);
		PrintUtil.print(arr1);
		arr1 = new int[] { 1, 2, 3 };
		test.duplicateZeros(arr1);
		PrintUtil.print(arr1);
	}

	public void duplicateZeros(int[] arr) {
		int i = 0;
		int count = 0;
		int length = arr.length;
		while (i + count < length) {
			if (arr[i++] == 0) {
				count++;
			}
		}
		for (i = i - 1; count > 0; i--) {
			if (i + count < length) {
				arr[i + count] = arr[i];
			}
			if (arr[i] == 0) {
				arr[i + --count] = arr[i];
			}
		}
	}

}
