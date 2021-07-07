package gracefulsoul.problems;

import java.util.Arrays;

public class MergeSortedArray {

	// https://leetcode.com/submissions/detail/518593122/
	public static void main(String[] args) {
		MergeSortedArray test = new MergeSortedArray();
		int[] arr1 = new int[] { 1, 2, 3, 0, 0, 0 };
		test.merge(arr1, 3, new int[] { 2, 5, 6 }, 3);
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = new int[] { 1 };
		test.merge(arr2, 1, new int[] {}, 0);
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = new int[] { 0 };
		test.merge(arr3, 0, new int[] { 1 }, 1);
		System.out.println(Arrays.toString(arr3));
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int length = m + n - 1;
		m--;
		n--;
		while (n >= 0) {
			nums1[length--] = m < 0 || nums1[m] < nums2[n] ? nums2[n--] : nums1[m--];
		}
	}

}
