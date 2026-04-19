package gracefulsoul.problems;

public class MaximumDistanceBetweenAPairOfValues {

	// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/submissions/1982142360/
	public static void main(String[] args) {
		MaximumDistanceBetweenAPairOfValues test = new MaximumDistanceBetweenAPairOfValues();
		System.out.println(test.maxDistance(new int[] { 55, 30, 5, 4, 2 }, new int[] { 100, 20, 10, 10, 5 }));
		System.out.println(test.maxDistance(new int[] { 2, 2, 2 }, new int[] { 10, 10, 1 }));
		System.out.println(test.maxDistance(new int[] { 30, 29, 19, 5 }, new int[] { 25, 25, 25, 25, 25 }));
	}

	public int maxDistance(int[] nums1, int[] nums2) {
		int result = 0;
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if (nums1[i] > nums2[j]) {
				i++;
			} else {
				result = Math.max(result, j++ - i);
			}
		}
		return result;
	}

}
