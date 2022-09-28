package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent {

	// https://leetcode.com/submissions/detail/810509987/
	public static void main(String[] args) {
		CutOffTreesForGolfEvent test = new CutOffTreesForGolfEvent();
		System.out.println(test.cutOffTree(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(0, 0, 4),
			Arrays.asList(7, 6, 5)
		)));
		System.out.println(test.cutOffTree(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(0, 0, 0),
			Arrays.asList(7, 6, 5)
		)));
		System.out.println(test.cutOffTree(Arrays.asList(
			Arrays.asList(2, 3, 4),
			Arrays.asList(0, 0, 5),
			Arrays.asList(8, 7, 6)
		)));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 }
	};
	
	public int cutOffTree(List<List<Integer>> forest) {
		int row = forest.size();
		int col = forest.get(0).size();
		List<int[]> trees = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (forest.get(i).get(j) > 1) {
					trees.add(new int[] { i, j, forest.get(i).get(j) });
				}
			}
		}
		Collections.sort(trees, (tree1, tree2) -> tree1[2] - tree2[2]);
		int result = 0;
		int x = 0;
		int y = 0;
		for (int[] tree : trees) {
			int steps = this.bfs(forest, row, col, x, y, tree);
			if (steps < 0) {
				return -1;
			}
			result += steps;
			x = tree[0];
			y = tree[1];
		}
		return result;
	}

	private int bfs(List<List<Integer>> forest, int row, int col, int x, int y, int[] tree) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		boolean[][] visited = new boolean[row][col];
		visited[x][y] = true;
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				if (curr[0] == tree[0] && curr[1] == tree[1]) {
					return level;
				}
				for (int[] direction : DIRECTIONS) {
					x = direction[0] + curr[0];
					y = direction[1] + curr[1];
					if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || forest.get(x).get(y) == 0) {
						continue;
					}
					visited[x][y] = true;
					queue.add(new int[] { x, y });
				}
			}
			level++;
		}
		return -1;
	}

}
