package gracefulsoul.problems;

import java.util.Arrays;

public class FourSumII {

	// https://leetcode.com/submissions/detail/679374465/
	public static void main(String[] args) {
		FourSumII test = new FourSumII();
		System.out.println(test.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }));
		System.out.println(test.fourSumCount(new int[] { 0 }, new int[] { 0 }, new int[] { 0 }, new int[] { 0 }));
	}

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int length = nums1.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Arrays.sort(nums3);
		Arrays.sort(nums4);
		int min = Math.min(nums1[0] + nums2[0], -(nums3[length - 1] + nums4[length - 1]));
		int max = Math.max(nums1[length - 1] + nums2[length - 1], -(nums3[0] + nums4[0]));
		int[] map = new int[max - min + 1];
		for (int num1 : nums1) {
			for (int num2 : nums2) {
				map[num1 + num2 - min]++;
			}
		}
		int result = 0;
		for (int num3 : nums3) {
			for (int num4 : nums4) {
				result += map[-num3 - num4 - min];
			}
		}
		return result;
	}

}
