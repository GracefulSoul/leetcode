package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class FindTheNumberOfDistinctColorsAmongTheBalls {

	// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/submissions/1534691152/
	public static void main(String[] args) {
		FindTheNumberOfDistinctColorsAmongTheBalls test = new FindTheNumberOfDistinctColorsAmongTheBalls();
		PrintUtil.print(test.queryResults(4, new int[][] {
			{ 1, 4 },
			{ 2, 5 },
			{ 1, 3 },
			{ 3, 4 }
		}));
		PrintUtil.print(test.queryResults(4, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 2 },
			{ 3, 4 },
			{ 4, 5 }
		}));
	}

	public int[] queryResults(int limit, int[][] queries) {
		Map<Integer, Integer> ballMap = new HashMap<>();
		Map<Integer, Integer> colorMap = new HashMap<>();
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int[] curr = queries[i];
			int ball = curr[0];
			int color = curr[1];
			if (ballMap.containsKey(ball)) {
				if (ballMap.get(ball) != color) {
					int prev = ballMap.get(ball);
					if (colorMap.get(prev) == 1) {
						colorMap.remove(prev);
					} else {
						colorMap.put(prev, colorMap.get(prev) - 1);
					}
					ballMap.put(ball, color);
					colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
				}
			} else {
				ballMap.put(ball, color);
				colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
			}
			result[i] = colorMap.size();
		}
		return result;
	}

}
