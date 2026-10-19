package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

	// https://leetcode.com/problems/find-target-indices-after-sorting-array/submissions/2176221052/
	public static void main(String[] args) {
		FindTargetIndicesAfterSortingArray test = new FindTargetIndicesAfterSortingArray();
		System.out.println(test.targetIndices(new int[] { 1, 2, 5, 2, 3 }, 2));
		System.out.println(test.targetIndices(new int[] { 1, 2, 5, 2, 3 }, 3));
		System.out.println(test.targetIndices(new int[] { 1, 2, 5, 2, 3 }, 5));
	}

	public List<Integer> targetIndices(int[] nums, int target) {
		int count = 0;
		int lower = 0;
		for (int num : nums) {
			if (num == target) {
				count++;
			}
			if (num < target) {
				lower++;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			result.add(lower++);
		}
		return result;
	}

}
