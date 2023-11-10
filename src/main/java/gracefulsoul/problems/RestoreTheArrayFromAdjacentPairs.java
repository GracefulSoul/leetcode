package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class RestoreTheArrayFromAdjacentPairs {

	// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/submissions/1095835860/
	public static void main(String[] args) {
		RestoreTheArrayFromAdjacentPairs test = new RestoreTheArrayFromAdjacentPairs();
		PrintUtil.print(test.restoreArray(new int[][] {
			{ 2, 1 },
			{ 3, 4 },
			{ 3, 2 }
		}));
		PrintUtil.print(test.restoreArray(new int[][] {
			{ 4, -2 },
			{ 1, 4 },
			{ -3, 1 }
		}));
		PrintUtil.print(test.restoreArray(new int[][] {
			{ 100000, -100000 }
		}));
	}

	public int[] restoreArray(int[][] adjacentPairs) {
		int length = adjacentPairs.length;
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			int[] adjacentPair = adjacentPairs[i];
			if (map.containsKey(adjacentPair[0])) {
				map.get(adjacentPair[0])[1] = adjacentPair[1];
			} else {
				map.put(adjacentPair[0], new int[] { adjacentPair[1], -1000000 });
			}
			if (map.containsKey(adjacentPair[1])) {
				map.get(adjacentPair[1])[1] = adjacentPair[0];
			} else {
				map.put(adjacentPair[1], new int[] { adjacentPair[0], -1000000 });
			}
		}
		int[] result = new int[length + 1];
		int start = -1000000;
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			if (entry.getValue()[1] == -1000000) {
				start = entry.getKey();
			}
		}
		result[0] = start;
		for (int i = 1, value = -1000000; i < result.length; i++) {
			int[] pair = map.get(start);
			int temp = pair[0] == value ? pair[1] : pair[0];
			result[i] = temp;
			value = start;
			start = temp;
		}
		return result;
	}

}
