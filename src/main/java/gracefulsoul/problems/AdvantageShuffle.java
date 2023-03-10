package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class AdvantageShuffle {

	// https://leetcode.com/problems/advantage-shuffle/submissions/912940359/
	public static void main(String[] args) {
		AdvantageShuffle test = new AdvantageShuffle();
		PrintUtil.print(test.advantageCount(new int[] { 2, 7, 11, 15 }, new int[] { 1, 10, 4, 11 }));
		PrintUtil.print(test.advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 }));
	}

	public int[] advantageCount(int[] nums1, int[] nums2) {
		int length = nums1.length;
		Integer[] position = new Integer[length];
		for (int i = 0; i < length; i++) {
			position[i] = i;
		}
		int result[] = new int[length];
		Arrays.sort(position, (i, j) -> nums2[i] - nums2[j]);
		Arrays.sort(nums1);
		int low = 0;
		int high = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			int index = position[i];
			if (nums2[index] < nums1[high]) {
				result[index] = nums1[high--];
			} else {
				result[index] = nums1[low++];
			}
		}
		return result;
	}

}
