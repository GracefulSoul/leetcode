package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangingFruits {

	// https://leetcode.com/problems/rearranging-fruits/submissions/1721256563/
	public static void main(String[] args) {
		RearrangingFruits test = new RearrangingFruits();
		System.out.println(test.minCost(new int[] { 4, 2, 2, 2 }, new int[] { 1, 4, 1, 2 }));
		System.out.println(test.minCost(new int[] { 2, 3, 4, 1 }, new int[] { 3, 2, 5, 1 }));
	}

	public long minCost(int[] basket1, int[] basket2) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int x : basket1) {
			count.put(x, count.getOrDefault(x, 0) + 1);
		}
		for (int x : basket2) {
			count.put(x, count.getOrDefault(x, 0) - 1);
		}
		List<Integer> swap = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				return -1;
			}
			min = Math.min(min, entry.getKey());
			for (int i = 0; i < Math.abs(entry.getValue()) / 2; i++) {
				swap.add(entry.getKey());
			}
		}
		Collections.sort(swap);
		long result = 0;
		for (int i = 0; i < swap.size() / 2; i++) {
			result += Math.min(swap.get(i), 2 * min);
		}
		return result;
	}

}
