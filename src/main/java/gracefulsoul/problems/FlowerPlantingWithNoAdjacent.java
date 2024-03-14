package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class FlowerPlantingWithNoAdjacent {

	// https://leetcode.com/problems/flower-planting-with-no-adjacent/submissions/1203375801/
	public static void main(String[] args) {
		FlowerPlantingWithNoAdjacent test = new FlowerPlantingWithNoAdjacent();
		PrintUtil.print(test.gardenNoAdj(3, new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 1 }
		}));
		PrintUtil.print(test.gardenNoAdj(4, new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
		PrintUtil.print(test.gardenNoAdj(3, new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 4, 1 },
			{ 1, 3 },
			{ 2, 4 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int[] gardenNoAdj(int n, int[][] paths) {
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] path : paths) {
			int x = path[0] - 1;
			int y = path[1] - 1;
			graph[x].add(y);
			graph[y].add(x);
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int[] colors = new int[5];
			for (int neighbor : graph[i]) {
				colors[result[neighbor]] = 1;
			}
			for (int j = 4; j > 0; j--) {
				if (colors[j] == 0) {
					result[i] = j;
				}
			}
		}
		return result;
	}

}
