package gracefulsoul.problems;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

	// https://leetcode.com/problems/k-radius-subarray-averages/submissions/975455923/
	public static void main(String[] args) {
		KRadiusSubarrayAverages test = new KRadiusSubarrayAverages();
		System.out.println(test.getAverages(new int[] { 7, 4, 3, 9, 1, 8, 5, 2, 6 }, 3));
		System.out.println(test.getAverages(new int[] { 100000 }, 0));
		System.out.println(test.getAverages(new int[] { 8 }, 100000));
	}

	public int[] getAverages(int[] nums, int k) {
		int length = nums.length;
		int size = (2 * k) + 1;
		int[] result = new int[length];
		Arrays.fill(result, -1);
		if (length < size) {
			return result;
		}
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += nums[i];
			if (i - size >= 0) {
				sum -= nums[i - size];
			}
			if (i >= size - 1) {
				result[i - k] = (int) (sum / size);
			}
		}
		return result;
	}

}
