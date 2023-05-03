package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class CatAndMouse {

	// https://leetcode.com/problems/cat-and-mouse/submissions/943764666/
	public static void main(String[] args) {
		CatAndMouse test = new CatAndMouse();
		System.out.println(test.catMouseGame(new int[][] {
			{ 2, 5 },
			{ 3 },
			{ 0, 4, 5 },
			{ 1, 4, 5 },
			{ 2, 3 },
			{ 0, 2, 3 }
		}));
		System.out.println(test.catMouseGame(new int[][] {
			{ 1, 3 },
			{ 0 },
			{ 3 },
			{ 0, 2 }
		}));
	}

	public int catMouseGame(int[][] graph) {
		int length = graph.length;
		int[][][] color = new int[length][length][2];
		int[][][] outdegree = new int[length][length][2];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				outdegree[i][j][0] = graph[j].length;
				outdegree[i][j][1] = graph[i].length;
				for (int k : graph[i]) {
					if (k == 0) {
						outdegree[i][j][1]--;
						break;
					}
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		for (int k = 1; k < length; k++) {
			for (int m = 0; m < 2; m++) {
				color[k][0][m] = 1;
				queue.offer(new int[] { k, 0, m, 1 });
				color[k][k][m] = 2;
				queue.offer(new int[] { k, k, m, 2 });
			}
		}
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cat = curr[0];
			int mouse = curr[1];
			int mouseMove = curr[2];
			int c = curr[3];
			if (cat == 2 && mouse == 1 && mouseMove == 0) {
				return c;
			}
			int prevMouseMove = 1 - mouseMove;
			for (int prev : graph[prevMouseMove == 1 ? cat : mouse]) {
				int prevCat = prevMouseMove == 1 ? prev : cat;
				int prevMouse = prevMouseMove == 1 ? mouse : prev;
				if (prevCat == 0) {
					continue;
				}
				if (color[prevCat][prevMouse][prevMouseMove] > 0) {
					continue;
				}
				if (prevMouseMove == 1 && c == 2 || prevMouseMove == 0 && c == 1
						|| --outdegree[prevCat][prevMouse][prevMouseMove] == 0) {
					color[prevCat][prevMouse][prevMouseMove] = c;
					queue.offer(new int[] { prevCat, prevMouse, prevMouseMove, c });
				}
			}
		}
		return color[2][1][0];
	}

}
