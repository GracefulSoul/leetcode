package gracefulsoul.problems;

import java.util.Arrays;

public class LargestValuesFromLabels {

	// https://leetcode.com/problems/largest-values-from-labels/submissions/1238912472/
	public static void main(String[] args) {
		LargestValuesFromLabels test = new LargestValuesFromLabels();
		System.out.println(test.largestValsFromLabels(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 1, 2, 2, 3 }, 3, 1));
		System.out.println(test.largestValsFromLabels(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 3, 3, 3, 2 }, 3, 2));
		System.out.println(test.largestValsFromLabels(new int[] { 9, 8, 8, 7, 6 }, new int[] { 0, 0, 0, 1, 1 }, 3, 1));
	}

	public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
		int length = values.length;
		int[][] nums = new int[length][2];
		for (int i = 0; i < length; i++) {
			nums[i][0] = values[i];
			nums[i][1] = labels[i];
		}
		Arrays.sort(nums, (a, b) -> b[0] - a[0]);
		int result = 0;
		int[] count = new int[20001];
		for (int[] num : nums) {
			if (count[num[1]] < useLimit) {
				count[num[1]]++;
				numWanted--;
				result += num[0];
			}
			if (numWanted == 0) {
				break;
			}
		}
		return result;
	}

}
