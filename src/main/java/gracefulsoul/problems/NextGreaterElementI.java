package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class NextGreaterElementI {

	// https://leetcode.com/submissions/detail/701099243/
	public static void main(String[] args) {
		NextGreaterElementI test = new NextGreaterElementI();
		PrintUtil.print(test.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
		PrintUtil.print(test.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }));
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int idx = 0; idx < nums2.length; idx++) {
			map.put(nums2[idx], idx);
		}
		for (int idx = 0; idx < result.length; idx++) {
			result[idx] = this.findNextGreaterElement(nums2, map.get(nums1[idx]));
		}
		return result;
	}

	private int findNextGreaterElement(int[] nums2, int index) {
		int num = nums2[index];
		int nextGreaterElement = -1;
		for (int i = index + 1; i < nums2.length; i++) {
			if (nums2[i] > num) {
				return nums2[i];
			}
		}
		return nextGreaterElement;
	}

}
