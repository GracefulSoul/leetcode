package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class MergeTwo2DArraysBySummingValues {

	// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/submissions/1560381340/
	public static void main(String[] args) {
		MergeTwo2DArraysBySummingValues test = new MergeTwo2DArraysBySummingValues();
		PrintUtil.print(test.mergeArrays(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 4, 5 }
		}, new int[][] {
			{ 1, 4 },
			{ 3, 2 },
			{ 4, 1 }
		}));
		PrintUtil.print(test.mergeArrays(new int[][] {
			{ 2, 4 },
			{ 3, 6 },
			{ 5, 5 }
		}, new int[][] {
			{ 1, 3 },
			{ 4, 3 }
		}));
	}

	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		int i = 0;
		int j = 0;
		List<int[]> result = new ArrayList<>();
		while (i < nums1Length && j < nums2Length) {
			if (nums1[i][0] == nums2[j][0]) {
				result.add(new int[] { nums1[i][0], nums1[i++][1] + nums2[j++][1] });
			} else if (nums1[i][0] < nums2[j][0]) {
				result.add(nums1[i++]);
			} else {
				result.add(nums2[j++]);
			}
		}
		while (i < nums1Length) {
			result.add(nums1[i++]);
		}
		while (j < nums2Length) {
			result.add(nums2[j++]);
		}
		return result.toArray(new int[result.size()][]);
	}

}
