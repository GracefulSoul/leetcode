package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ThreeEqualParts {

	// https://leetcode.com/problems/three-equal-parts/submissions/955703185/
	public static void main(String[] args) {
		ThreeEqualParts test = new ThreeEqualParts();
		PrintUtil.print(test.threeEqualParts(new int[] { 1, 0, 1, 0, 1 }));
		PrintUtil.print(test.threeEqualParts(new int[] { 1, 1, 0, 1, 1 }));
		PrintUtil.print(test.threeEqualParts(new int[] { 1, 1, 0, 0, 1 }));
	}

	public int[] threeEqualParts(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (num == 1) {
				count++;
			}
		}
		if (count == 0) {
			return new int[] { 0, 2 };
		}
		if (count % 3 != 0) {
			return new int[] { -1, -1 };
		}
		int index = 0;
		for (int i = arr.length - 1, oneThird = count / 3; i >= 0; i--) {
			if (arr[i] == 1 && --oneThird == 0) {
				index = i;
				break;
			}
		}
		int first = this.findIndex(arr, 0, index);
		if (first < 0) {
			return new int[] { -1, -1 };
		}
		int second = this.findIndex(arr, first + 1, index);
		if (second < 0) {
			return new int[] { -1, -1 };
		}
		return new int[] { first, second + 1 };
	}

	private int findIndex(int[] arr, int left, int right) {
		while (arr[left] == 0) {
			left++;
		}
		while (right < arr.length) {
			if (arr[left++] != arr[right++]) {
				return -1;
			}
		}
		return left - 1;
	}

}
