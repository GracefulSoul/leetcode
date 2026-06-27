package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class FindTheMaximumNumberOfElementsInSubset {

	// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/submissions/2047740878/
	public static void main(String[] args) {
		FindTheMaximumNumberOfElementsInSubset test = new FindTheMaximumNumberOfElementsInSubset();
		System.out.println(test.maximumLength(new int[] { 5, 4, 1, 2, 2 }));
		System.out.println(test.maximumLength(new int[] { 1, 3, 2, 4 }));
	}

	public int maximumLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.merge(num, 1, Integer::sum);
		}
		int result = (map.getOrDefault(1, 0) - 1) | 1;
		map.remove(1);
		for (int key : map.keySet()) {
			int sqrt = (int) Math.sqrt(key);
			if (sqrt * sqrt == key && map.getOrDefault(sqrt, 0) > 1) {
				continue;
			}
			int n = 0;
			int i = key;
			while (i < 1e9 && map.containsKey(i) && map.get(i) > 1) {
				n += 2;
				i *= i;
			}
			result = Math.max(result, n + (map.containsKey(i) ? 1 : -1));
		}
		return result;
	}

}
