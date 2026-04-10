package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {

	// https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/submissions/1974437964/
	public static void main(String[] args) {
		MinimumDistanceBetweenThreeEqualElementsI test = new MinimumDistanceBetweenThreeEqualElementsI();
		System.out.println(test.minimumDistance(new int[] { 1, 2, 1, 1, 3 }));
		System.out.println(test.minimumDistance(new int[] { 1, 1, 2, 3, 2, 1, 2 }));
		System.out.println(test.minimumDistance(new int[] { 1 }));
	}

	public int minimumDistance(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}
		int result = Integer.MAX_VALUE;
		for (List<Integer> list : map.values()) {
			for (int i = 0; i < list.size() - 2; i++) {
				result = Math.min(result, 2 * (list.get(i + 2) - list.get(i)));
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}
