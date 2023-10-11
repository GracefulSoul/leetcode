package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class NumberOfFlowersInFullBloom {

	// https://leetcode.com/problems/number-of-flowers-in-full-bloom/submissions/1072551506/
	public static void main(String[] args) {
		NumberOfFlowersInFullBloom test = new NumberOfFlowersInFullBloom();
		PrintUtil.print(test.fullBloomFlowers(new int[][] {
			{ 1, 6 },
			{ 3, 7 },
			{ 9, 12 },
			{ 4, 13 }
		}, new int[] { 2, 3, 7, 11 }));
		PrintUtil.print(test.fullBloomFlowers(new int[][] {
			{ 1, 10 },
			{ 3, 3 }
		}, new int[] { 2, 2, 1 }));
	}

	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		int length = flowers.length;
		int[] start = new int[length];
		int[] end = new int[length];
		for (int i = 0; i < length; i++) {
			start[i] = flowers[i][0];
			end[i] = flowers[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		length = people.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = this.getIndex(start, people[i] + 1) - this.getIndex(end, people[i]);
		}
		return result;
	}

	private int getIndex(int[] flowers, int target) {
		int left = 0;
		int right = flowers.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (flowers[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return flowers[left] >= target ? left : left + 1;
	}

}
