package gracefulsoul.problems;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {

	// https://leetcode.com/problems/array-of-doubled-pairs/submissions/1000635763/
	public static void main(String[] args) {
		ArrayOfDoubledPairs test = new ArrayOfDoubledPairs();
		System.out.println(test.canReorderDoubled(new int[] { 3, 1, 3, 6 }));
		System.out.println(test.canReorderDoubled(new int[] { 2, 1, 2, 6 }));
		System.out.println(test.canReorderDoubled(new int[] { 4, -2, 2, -4 }));
	}

	public boolean canReorderDoubled(int[] arr) {
		Map<Integer, Integer> count = new TreeMap<>();
		for (int num : arr) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		for (int key : count.keySet()) {
			if (count.get(key) == 0) {
				continue;
			}
			int num = key < 0 ? key / 2 : key * 2;
			if ((key < 0 && key % 2 != 0) || count.get(key) > count.getOrDefault(num, 0)) {
				return false;
			}
			count.put(num, count.get(num) - count.get(key));
		}
		return true;
	}

}
