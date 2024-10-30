package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumNumberOfRemovalsToMakeMountainArray {

	public static void main(String[] args) {
		MinimumNumberOfRemovalsToMakeMountainArray test = new MinimumNumberOfRemovalsToMakeMountainArray();
		System.out.println(test.minimumMountainRemovals(new int[] { 1, 3, 1 }));
		System.out.println(test.minimumMountainRemovals(new int[] { 2, 1, 1, 5, 6, 2, 3, 1 }));
	}

	public int minimumMountainRemovals(int[] nums) {
		int length = nums.length;
		int[] LIS = new int[length];
		int[] LDS = new int[length];
		Arrays.fill(LIS, 1);
		Arrays.fill(LDS, 1);
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && LIS[j] + 1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = length - 2; i >= 0; i--) {
			for (int j = length - 1; j > i; j--) {
				if (nums[i] > nums[j] && LDS[j] + 1 > LDS[i]) {
					LDS[i] = LDS[j] + 1;
				}
			}
			if (LIS[i] > 1 && LDS[i] > 1) {
				max = Math.max(LIS[i] + LDS[i] - 1, max);
			}
		}
		return length - max;
	}

}
