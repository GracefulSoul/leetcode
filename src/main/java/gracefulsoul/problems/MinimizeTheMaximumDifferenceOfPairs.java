package gracefulsoul.problems;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {

	// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/submissions/1016630081/
	public static void main(String[] args) {
		MinimizeTheMaximumDifferenceOfPairs test = new MinimizeTheMaximumDifferenceOfPairs();
		System.out.println(test.minimizeMax(new int[] { 10, 1, 2, 7, 1, 3 }, 2));
		System.out.println(test.minimizeMax(new int[] { 4, 2, 1, 2 }, 1));
	}

	public int minimizeMax(int[] nums, int p) {
		Arrays.sort(nums);
		int length = nums.length;
		int left = 0;
		int right = nums[length - 1] - nums[0];
		while (left < right) {
			int mid = left + ((right - left) / 2);
			int i = 0;
			for (int j = 1; j < length && i < p; j++) {
				if (nums[j] - nums[j - 1] <= mid) {
					i++;
					j++;
				}
			}
			if (i >= p) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
