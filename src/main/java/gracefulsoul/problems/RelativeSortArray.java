package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class RelativeSortArray {

	// https://leetcode.com/problems/relative-sort-array/submissions/1284756861/
	public static void main(String[] args) {
		RelativeSortArray test = new RelativeSortArray();
		PrintUtil.print(test.relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 }));
		PrintUtil.print(test.relativeSortArray(new int[] { 28, 6, 22, 8, 44, 17 }, new int[] { 22, 28, 8, 6 }));
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] count = new int[1001];
		for (int num : arr1) {
			count[num]++;
		}
		int index = 0;
		for (int num : arr2) {
			while (count[num]-- > 0) {
				arr1[index++] = num;
			}
		}
		for (int i = 0; index < arr1.length && i < 1001; i++) {
			while (count[i]-- > 0) {
				arr1[index++] = i;
			}
		}
		return arr1;
	}

}
