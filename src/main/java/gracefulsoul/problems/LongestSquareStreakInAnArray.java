package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreakInAnArray {

	// https://leetcode.com/problems/longest-square-streak-in-an-array/submissions/1436045278/
	public static void main(String[] args) {
		LongestSquareStreakInAnArray test = new LongestSquareStreakInAnArray();
		System.out.println(test.longestSquareStreak(new int[] { 4, 3, 6, 16, 8, 2 }));
		System.out.println(test.longestSquareStreak(new int[] { 2, 3, 5, 6, 7 }));
	}

	public int longestSquareStreak(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(nums);
		int result = -1;
		for (int num : nums) {
			int sqrt = (int) Math.sqrt(num);
			if (sqrt * sqrt == num && map.containsKey(sqrt)) {
				map.put(num, map.get(sqrt) + 1);
				result = Math.max(result, map.get(num));
			} else {
				map.put(num, 1);
			}
		}
		return result;
	}

}
