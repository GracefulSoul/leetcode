package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class PreviousPermutationWithOneSwap {

	// https://leetcode.com/problems/previous-permutation-with-one-swap/submissions/1211315378/
	public static void main(String[] args) {
		PreviousPermutationWithOneSwap test = new PreviousPermutationWithOneSwap();
		PrintUtil.print(test.prevPermOpt1(new int[] { 3, 2, 1 }));
		PrintUtil.print(test.prevPermOpt1(new int[] { 1, 1, 5 }));
		PrintUtil.print(test.prevPermOpt1(new int[] { 1, 9, 4, 6, 7 }));
	}

	public int[] prevPermOpt1(int[] arr) {
		int i = arr.length - 2;
		int j = arr.length - 1;
		while (i >= 0 && arr[i] <= arr[i + 1]) {
			i--;
		}
		if (i < 0) {
			return arr;
		}
		while (arr[j] >= arr[i] || (j > 0 && arr[j] == arr[j - 1])) {
			j--;
		}
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		return arr;
	}

}
