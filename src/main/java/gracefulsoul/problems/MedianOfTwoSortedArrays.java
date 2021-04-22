package gracefulsoul.problems;

public class MedianOfTwoSortedArrays {

	// https://leetcode.com/submissions/detail/479212877/
	public static void main(String[] args) {
		MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
		System.out.println(test.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(test.findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(test.findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(test.findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = this.mergeNums(nums1, nums2);
		int mid = nums.length / 2;
		return nums.length % 2 == 0 ? (double) (nums[mid - 1] + nums[mid]) / 2 : nums[mid];
	}

	private int[] mergeNums(int[] nums1, int[] nums2) {
		int[] mergeNums = new int[nums1.length + nums2.length];
		int idx1 = 0;
		int idx2 = 0;
		for (int idx = 0; idx < mergeNums.length; idx++) {
			if (idx1 < nums1.length && (idx2 >= nums2.length || nums1[idx1] <= nums2[idx2])) {
				mergeNums[idx] = nums1[idx1];
				idx1++;
			} else if (idx2 < nums2.length && (idx1 >= nums1.length || nums1[idx1] > nums2[idx2])) {
				mergeNums[idx] = nums2[idx2];
				idx2++;
			}
		}
		return mergeNums;
	}

}
