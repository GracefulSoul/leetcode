package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class IntersectionOfTwoArraysII {

	// https://leetcode.com/submissions/detail/625820802/
	public static void main(String[] args) {
		IntersectionOfTwoArraysII test = new IntersectionOfTwoArraysII();
		PrintUtil.print(test.intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
		PrintUtil.print(test.intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int[] count = new int[1001];
		for (int num : nums1) {
			count[num]++;
		}
		int[] result = new int[nums1.length];
		int index = 0;
		for (int num : nums2) {
			if (count[num] > 0) {
				result[index++] = num;
				count[num]--;
			}
		}
		return Arrays.copyOf(result, index);
	}


}
