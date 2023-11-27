package gracefulsoul.problems;

public class MinimumSwapsToMakeSequencesIncreasing {

	// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/submissions/876758394/
	public static void main(String[] args) {
		MinimumSwapsToMakeSequencesIncreasing test = new MinimumSwapsToMakeSequencesIncreasing();
		System.out.println(test.minSwap(new int[] { 1, 3, 5, 4 }, new int[] { 1, 2, 3, 7 }));
		System.out.println(test.minSwap(new int[] { 0, 3, 5, 8, 9 }, new int[] { 2, 1, 4, 6, 9 }));
	}

	public int minSwap(int[] nums1, int[] nums2) {
		int swap = 1;
		int fix = 0;
		for (int idx = 1; idx < nums1.length; idx++) {
			if (nums1[idx - 1] >= nums2[idx] || nums2[idx - 1] >= nums1[idx]) {
				swap++;
			} else if (nums1[idx - 1] >= nums1[idx] || nums2[idx - 1] >= nums2[idx]) {
				int temp = swap;
				swap = fix + 1;
				fix = temp;
			} else {
				int min = Math.min(swap, fix);
				swap = min + 1;
				fix = min;
			}
		}
		return Math.min(swap, fix);
	}

}
