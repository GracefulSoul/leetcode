package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class ValidArrangementOfPairs {

	// https://leetcode.com/problems/valid-arrangement-of-pairs/submissions/1466176627/
	public static void main(String[] args) {
		ValidArrangementOfPairs test = new ValidArrangementOfPairs();
		PrintUtil.print(test.validArrangement(new int[][] {
			{ 5, 1 },
			{ 4, 5 },
			{ 11, 9 },
			{ 9, 4 }
		}));
		PrintUtil.print(test.validArrangement(new int[][] {
			{ 1, 3 },
			{ 3, 2 },
			{ 2, 1 }
		}));
	}

	public int[][] validArrangement(int[][] pairs) {
		Map<Integer, List<Integer>> list = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] pair : pairs) {
			list.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
			map.merge(pair[0], 1, Integer::sum);
			map.merge(pair[1], -1, Integer::sum);
		}
		int start = pairs[0][0];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				start = entry.getKey();
				break;
			}
		}
		List<Integer> path = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		deque.push(start);
		while (!deque.isEmpty()) {
			List<Integer> neighbors = list.getOrDefault(deque.peek(), new ArrayList<>());
			if (neighbors.isEmpty()) {
				path.add(deque.pop());
			} else {
				deque.push(neighbors.get(neighbors.size() - 1));
				neighbors.remove(neighbors.size() - 1);
			}
		}
		int size = path.size();
		int[][] result = new int[size - 1][2];
		for (int i = size - 1; i > 0; --i) {
			result[size - 1 - i] = new int[] { path.get(i), path.get(i - 1) };
		}
		return result;
	}

}
