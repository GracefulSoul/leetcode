package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class NextGreaterElementI {

	// https://leetcode.com/submissions/detail/701105888/
	public static void main(String[] args) {
		NextGreaterElementI test = new NextGreaterElementI();
		PrintUtil.print(test.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
		PrintUtil.print(test.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }));
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int idx = 0; idx < nums2.length; idx++) {
			map.put(nums2[idx], idx);
		}
		for (int idx = 0; idx < nums1.length; idx++) {
			nums1[idx] = this.findNextGreaterElement(nums2, map.get(nums1[idx]));
		}
		return nums1;
	}

	private int findNextGreaterElement(int[] nums2, int index) {
		int num = nums2[index];
		int nextGreaterElement = -1;
		for (int idx = index + 1; idx < nums2.length; idx++) {
			if (nums2[idx] > num) {
				return nums2[idx];
			}
		}
		return nextGreaterElement;
	}

}
