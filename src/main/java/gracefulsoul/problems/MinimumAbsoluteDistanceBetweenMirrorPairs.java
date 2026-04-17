package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {

	// https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/submissions/1981022072/
	public static void main(String[] args) {
		MinimumAbsoluteDistanceBetweenMirrorPairs test = new MinimumAbsoluteDistanceBetweenMirrorPairs();
		System.out.println(test.minMirrorPairDistance(new int[] { 12, 21, 45, 33, 54 }));
		System.out.println(test.minMirrorPairDistance(new int[] { 120, 21 }));
		System.out.println(test.minMirrorPairDistance(new int[] { 21, 120 }));
	}

	public int minMirrorPairDistance(int[] nums) {
		int length = nums.length;
		int result = 100000;
		Map<Integer, Integer> seen = new HashMap<>();
		for (int i = 0; i < length; i++) {
			int num = nums[i];
			if (seen.containsKey(num)) {
				result = Math.min(result, i - seen.get(num));
			}
			int temp = 0;
			for (; num > 0; num /= 10) {
				temp = (temp * 10) + (num % 10);
			}
			seen.put(temp, i);
		}
		return result == 100000 ? -1 : result;
	}

}
