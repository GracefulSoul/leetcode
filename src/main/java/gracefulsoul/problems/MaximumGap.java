package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumGap {

	// https://leetcode.com/submissions/detail/555079290/
	public static void main(String[] args) {
		MaximumGap test = new MaximumGap();
		System.out.println(test.maximumGap(new int[] { 3, 6, 9, 1 }));
		System.out.println(test.maximumGap(new int[] { 10 }));
	}

	public int maximumGap(int[] nums) {
		int length = nums.length;
		if (length < 2) {
			return 0;
		}
		int min = nums[0];
		int max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		if (min == max) {
			return 0;
		}
		int gap = (int) Math.ceil((double) (max - min) / (length - 1));
		int bucketMin[] = new int[length];
		int bucketMax[] = new int[length];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		for (int num : nums) {
			int idx = (num - min) / gap;
			bucketMin[idx] = Math.min(bucketMin[idx], num);
			bucketMax[idx] = Math.max(bucketMax[idx], num);
		}
		for (int idx = 0; idx < bucketMin.length; ++idx) {
			if (bucketMin[idx] != Integer.MAX_VALUE) {
				gap = Math.max(gap, bucketMin[idx] - min);
				min = bucketMax[idx];
			}
		}
		return gap;
	}

}
