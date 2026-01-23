package gracefulsoul.problems;

import java.util.TreeSet;

public class MinimumPairRemovalToSortArrayII {

	// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii/submissions/1894222441/
	public static void main(String[] args) {
		MinimumPairRemovalToSortArrayII test = new MinimumPairRemovalToSortArrayII();
		System.out.println(test.minimumPairRemoval(new int[] { 5, 2, 3, 1 }));
		System.out.println(test.minimumPairRemoval(new int[] { 1, 2, 2 }));
	}

	public int minimumPairRemoval(int[] nums) {
		int length = nums.length;
		if (length <= 1) {
			return 0;
		}
		long[] array = new long[length];
		int[] left = new int[length];
		int[] right = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = nums[i];
			left[i] = i - 1;
			right[i] = i + 1;
		}
		int count = 0;
		for (int i = 0; i < length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				count++;
			}
		}
		TreeSet<long[]> set = new TreeSet<>((a, b) -> {
			if (a[0] != b[0]) {
				return Long.compare(a[0], b[0]);
			} else {
				return Long.compare(a[1], b[1]);
			}
		});
		for (int i = 0; i < length - 1; i++) {
			set.add(new long[] { array[i] + array[i + 1], i });
		}
		int result = 0;
		while (count > 0) {
			result++;
			long[] curr = set.pollFirst();
			int i = (int) curr[1];
			int j = right[i];
			if (j >= length) {
				continue;
			}
			int prev = left[i];
			int next = right[j];
			if (prev >= 0) {
				set.remove(new long[] { array[prev] + array[i], prev });
				if (array[prev] > array[i])
					count--;
			}
			if (next < length) {
				set.remove(new long[] { array[j] + array[next], j });
				if (array[j] > array[next])
					count--;
			}
			if (array[i] > array[j]) {
				count--;
			}
			array[i] = array[i] + array[j];
			right[i] = next;
			if (next < length) {
				left[next] = i;
			}
			if (prev >= 0) {
				set.add(new long[] { array[prev] + array[i], prev });
				if (array[prev] > array[i]) {
					count++;
				}
			}
			if (next < length) {
				set.add(new long[] { array[i] + array[next], i });
				if (array[i] > array[next]) {
					count++;
				}
			}
		}
		return result;
	}

}
