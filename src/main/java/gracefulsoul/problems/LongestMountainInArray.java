package gracefulsoul.problems;

public class LongestMountainInArray {

	// https://leetcode.com/problems/longest-mountain-in-array/submissions/900878864/
	public static void main(String[] args) {
		LongestMountainInArray test = new LongestMountainInArray();
		System.out.println(test.longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }));
		System.out.println(test.longestMountain(new int[] { 2, 2, 2 }));
	}

	public int longestMountain(int[] arr) {
		int length = arr.length;
		int[] up = new int[length];
		int[] down = new int[length];
		for (int i = length - 2; i >= 0; --i) {
			if (arr[i] > arr[i + 1]) {
				down[i] = down[i + 1] + 1;
			}
		}
		int result = 0;
		for (int i = 0; i < length; ++i) {
			if (i > 0 && arr[i] > arr[i - 1]) {
				up[i] = up[i - 1] + 1;
			}
			if (up[i] > 0 && down[i] > 0) {
				result = Math.max(result, up[i] + down[i] + 1);
			}
		}
		return result;
	}

}
