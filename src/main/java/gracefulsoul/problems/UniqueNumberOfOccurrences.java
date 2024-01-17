package gracefulsoul.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

	// https://leetcode.com/problems/unique-number-of-occurrences/submissions/1148652467/
	public static void main(String[] args) {
		UniqueNumberOfOccurrences test = new UniqueNumberOfOccurrences();
		System.out.println(test.uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
		System.out.println(test.uniqueOccurrences(new int[] { 1, 2 }));
		System.out.println(test.uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for (int value : map.values()) {
			if (!set.add(value)) {
				return false;
			}
		}
		return true;
	}

}
