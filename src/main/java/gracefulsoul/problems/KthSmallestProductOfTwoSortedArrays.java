package gracefulsoul.problems;

public class KthSmallestProductOfTwoSortedArrays {

	// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/submissions/1675937104/
	public static void main(String[] args) {
		KthSmallestProductOfTwoSortedArrays test = new KthSmallestProductOfTwoSortedArrays();
		System.out.println(test.kthSmallestProduct(new int[] { 2, 5 }, new int[] { 3, 4 }, 2));
		System.out.println(test.kthSmallestProduct(new int[] { -4, -2, 0, 3 }, new int[] { 2, 4 }, 6));
		System.out.println(test.kthSmallestProduct(new int[] { -2, -1, 0, 1, 2 }, new int[] { -3, -1, 2, 4, 5 }, 3));
	}

	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
		long left = -10000000000L;
		long right = 10000000000L;
		while (left < right) {
			long mid = left + (right - left) / 2;
			if (this.getProductCounts(nums1, nums2, mid) < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private long getProductCounts(int[] nums1, int[] nums2, long target) {
		long count = 0;
		int length = nums2.length;
		for (int num : nums1) {
			if (num == 0) {
				if (target >= 0) {
					count += length;
				}
				continue;
			}
			int left = 0;
			int right = length;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if ((long) num * nums2[mid] <= target) {
					if (num > 0) {
						left = mid + 1;
					} else {
						right = mid;
					}
				} else {
					if (num > 0) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
			}
			count += (num > 0) ? left : length - left;
		}
		return count;
	}

}
