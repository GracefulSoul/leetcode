package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class IntersectionOfTwoArrays {

	// https://leetcode.com/submissions/detail/624904682/
	public static void main(String[] args) {
		IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();
		PrintUtil.print(test.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
		PrintUtil.print(test.intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		int[] count = new int[1000];
		for (int num : nums1) {
			count[num]++;
		}
		int[] result = new int[nums1.length];
		int index = 0;
		for (int num : nums2) {
			if (count[num] > 0) {
				result[index++] = num;
				count[num] = 0;
			}
		}
		return Arrays.copyOf(result, index);
	}

}
