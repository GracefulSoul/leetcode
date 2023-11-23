package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticSubarrays {

	// https://leetcode.com/problems/arithmetic-subarrays/submissions/1104789697/
	public static void main(String[] args) {
		ArithmeticSubarrays test = new ArithmeticSubarrays();
		System.out.println(test.checkArithmeticSubarrays(new int[] { 4, 6, 5, 9, 3, 7 }, new int[] { 0, 0, 2 }, new int[] { 2, 3, 5 }));
		System.out.println(test.checkArithmeticSubarrays(new int[] { -12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10 }, new int[] { 0, 1, 6, 4, 8, 7 }, new int[] { 4, 4, 9, 7, 9, 10 }));
	}

	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < l.length; i++) {
			result.add(this.checkArithmeticSubarrays(nums, l[i], r[i]));
		}
		return result;
	}

	private boolean checkArithmeticSubarrays(int[] nums, int left, int right) {
		if (right - left < 2) {
			return true;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		int diff = max - min;
		int length = right - left;
		if (diff % length != 0) {
			return false;
		}
		if (diff % length != 0) {
			return false;
		}
		diff /= length;
		if (diff == 0) {
			return true;
		}
		boolean[] visited = new boolean[length + 1];
		for (int i = left; i <= right; i++) {
			int value = nums[i] - min;
			if (value % diff != 0) {
				return false;
			} else {
				int index = value / diff;
				if (visited[index]) {
					return false;
				} else {
					visited[index] = true;
				}
			}
		}
		return true;
	}

}
