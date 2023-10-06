package gracefulsoul.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import gracefulsoul.util.PrintUtil;

public class GridIllumination {

	// https://leetcode.com/problems/grid-illumination/submissions/1068660463/
	public static void main(String[] args) {
		GridIllumination test = new GridIllumination();
		PrintUtil.print(test.gridIllumination(5, new int[][] {
			{ 0, 0 },
			{ 4, 4 }
		}, new int[][] {
			{ 1, 1 },
			{ 1, 0 }
		}));
		PrintUtil.print(test.gridIllumination(5, new int[][] {
			{ 0, 0 },
			{ 4, 4 }
		}, new int[][] {
			{ 1, 1 },
			{ 1, 1 }
		}));
		PrintUtil.print(test.gridIllumination(5, new int[][] {
			{ 0, 0 },
			{ 0, 4 }
		}, new int[][] {
			{ 0, 4 },
			{ 0, 1 },
			{ 1, 4 }
		}));
	}

	public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		Set<Long> lampSet = new HashSet<>();
		HashMap<Integer, Integer> rowMap = new HashMap<>();
		HashMap<Integer, Integer> colMap = new HashMap<>();
		HashMap<Integer, Integer> diffMap = new HashMap<>();
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		for (int[] lamp : lamps) {
			long num = ((long) lamp[0] << 32) + lamp[1];
			if (!lampSet.contains(num)) {
				lampSet.add(num);
				rowMap.put(lamp[0], rowMap.getOrDefault(lamp[0], 0) + 1);
				colMap.put(lamp[1], colMap.getOrDefault(lamp[1], 0) + 1);
				diffMap.put(lamp[0] - lamp[1], diffMap.getOrDefault(lamp[0] - lamp[1], 0) + 1);
				sumMap.put(lamp[0] + lamp[1], sumMap.getOrDefault(lamp[0] + lamp[1], 0) + 1);
			}
		}
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			if (rowMap.getOrDefault(query[0], 0) != 0
					|| colMap.getOrDefault(query[1], 0) != 0
					|| diffMap.getOrDefault(query[0] - query[1], 0) != 0
					|| sumMap.getOrDefault(query[0] + query[1], 0) != 0) {
				result[i] = 1;
			}
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					int x = query[0] + dx;
					int y = query[1] + dy;
					long num = ((long) x << 32) + y;
					if (lampSet.contains(num)) {
						lampSet.remove(num);
						rowMap.put(x, rowMap.get(x) - 1);
						colMap.put(y, colMap.get(y) - 1);
						diffMap.put(x - y, diffMap.get(x - y) - 1);
						sumMap.put(x + y, sumMap.get(x + y) - 1);
					}
				}
			}
		}
		return result;
	}

}
