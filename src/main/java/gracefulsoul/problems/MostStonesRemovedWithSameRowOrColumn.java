package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

	// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/submissions/995435449/
	public static void main(String[] args) {
		MostStonesRemovedWithSameRowOrColumn test = new MostStonesRemovedWithSameRowOrColumn();
		System.out.println(test.removeStones(new int[][] {
			{ 0, 0 },
			{ 0, 1 },
			{ 1, 0 },
			{ 1, 2 },
			{ 2, 1 },
			{ 2, 2 }
		}));
		System.out.println(test.removeStones(new int[][] {
			{ 0, 0 },
			{ 0, 2 },
			{ 1, 1 },
			{ 2, 0 },
			{ 2, 2 }
		}));
		System.out.println(test.removeStones(new int[][] {
			{ 0, 0 }
		}));
	}

	public int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet<>();
		int numOfIslands = 0;
		for (int[] stone : stones) {
			if (!visited.contains(stone)) {
				this.dfs(visited, stones, stone);
				numOfIslands++;
			}
		}
		return stones.length - numOfIslands;
	}

	private void dfs(Set<int[]> visited, int[][] stones, int[] prev) {
		visited.add(prev);
		for (int[] stone : stones) {
			if (!visited.contains(stone) && (prev[0] == stone[0] || prev[1] == stone[1])) {
				this.dfs(visited, stones, stone);
			}
		}
	}

}
