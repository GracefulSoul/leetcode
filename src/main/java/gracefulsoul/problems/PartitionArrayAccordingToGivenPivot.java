package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class PartitionArrayAccordingToGivenPivot {

	// https://leetcode.com/problems/partition-array-according-to-given-pivot/submissions/1560875880/
	public static void main(String[] args) {
		PartitionArrayAccordingToGivenPivot test = new PartitionArrayAccordingToGivenPivot();
		PrintUtil.print(test.pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10));
		PrintUtil.print(test.pivotArray(new int[] { -3, 4, 3, 2 }, 2));
	}

	public int[] pivotArray(int[] nums, int pivot) {
		int length = nums.length;
		int[] result = new int[length];
		int i = 0;
		int j = 0;
		int k = 0;
		for (int num : nums) {
			if (num <= pivot) {
				k++;
				if (num < pivot) {
					j++;
				}
			}
		}
		for (int num : nums) {
			if (num < pivot) {
				result[i++] = num;
			} else if (num > pivot) {
				result[k++] = num;
			} else {
				result[j++] = num;
			}
		}
		return result;
	}

}
