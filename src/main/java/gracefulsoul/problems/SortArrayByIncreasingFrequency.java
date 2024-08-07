package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SortArrayByIncreasingFrequency {

	// https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/1330500566/
	public static void main(String[] args) {
		SortArrayByIncreasingFrequency test = new SortArrayByIncreasingFrequency();
		PrintUtil.print(test.frequencySort(new int[] { 1, 1, 2, 2, 2, 3 }));
		PrintUtil.print(test.frequencySort(new int[] { 2, 3, 1, 3, 2 }));
		PrintUtil.print(test.frequencySort(new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 }));
	}

	public int[] frequencySort(int[] nums) {
		int[] counts = new int[201];
		for (int num : nums) {
			counts[num + 100]++;
		}
		for (int i = nums.length - 1; i >= 0;) {
			int max = 0;
			int index = -1;
			for (int j = 0; j < 201; j++) {
				if (counts[j] > max) {
					max = counts[j];
					index = j;
				}
			}
			int num = index - 100;
			while (max-- > 0) {
				nums[i--] = num;
			}
			counts[index] = 0;
		}
		return nums;
	}

}
