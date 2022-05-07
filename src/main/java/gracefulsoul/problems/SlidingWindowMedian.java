package gracefulsoul.problems;

import java.util.Arrays;

public class SlidingWindowMedian {

	// https://leetcode.com/submissions/detail/694667656/
	public static void main(String[] args) {
		SlidingWindowMedian test = new SlidingWindowMedian();
		print(test.medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
		print(test.medianSlidingWindow(new int[] { 1, 2, 3, 4, 2, 3, 1, 4, 2 }, 3));
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		int[] part = new int[k];
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			part[i] = nums[i];
		}
		Arrays.sort(part);
		result[0] = this.getMedian(part, k);
		for (int i = k, j = 1; i < nums.length; i++, j++) {
			this.delete(part, k, nums[i - k]);
			this.insert(part, k, nums[i]);
			result[j] = this.getMedian(part, k);
		}
		return result;
	}

	private double getMedian(int[] part, int size) {
		if (size % 2 == 1) {
			return (double) part[size / 2];
		} else {
			return (part[(size / 2) - 1] / 2.0) + (part[size / 2] / 2.0);
		}
	}

	private void delete(int[] part, int k, int value) {
		int left = 0;
		int right = k;
		while (left < right) {
			int m = left + (right - left) / 2;
			if (part[m] == value) {
				System.arraycopy(part, m + 1, part, m, k - (m + 1));
				part[k - 1] = value;
				return;
			}
			if (part[m] < value) {
				left = m + 1;
			} else {
				right = m;
			}
		}
	}

	private void insert(int[] part, int k, int value) {
		int left = 0;
		int right = k - 1;
		while (left < right) {
			int m = left + (right - left) / 2;
			if (part[m] < value) {
				left = m + 1;
			} else {
				right = m;
			}
		}
		System.arraycopy(part, left, part, left + 1, (k - 1) - left);
		part[left] = value;
	}

	private static void print(double[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
