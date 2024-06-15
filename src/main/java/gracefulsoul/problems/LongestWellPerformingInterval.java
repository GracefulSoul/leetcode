package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {

	// https://leetcode.com/problems/longest-well-performing-interval/submissions/1288586813/
	public static void main(String[] args) {
		LongestWellPerformingInterval test = new LongestWellPerformingInterval();
		System.out.println(test.longestWPI(new int[] { 9, 9, 6, 0, 6, 6, 9 }));
		System.out.println(test.longestWPI(new int[] { 6, 6, 6 }));
	}

	public int longestWPI(int[] hours) {
		int result = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < hours.length; i++) {
			sum += hours[i] > 8 ? 1 : -1;
			if (sum > 0) {
				result = i + 1;
			} else {
				map.putIfAbsent(sum, i);
				if (map.containsKey(sum - 1)) {
					result = Math.max(result, i - map.get(sum - 1));
				}
			}
		}
		return result;
	}

}
