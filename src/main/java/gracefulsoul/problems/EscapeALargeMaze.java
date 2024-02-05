package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class EscapeALargeMaze {

	// https://leetcode.com/problems/escape-a-large-maze/submissions/1166683052/
	public static void main(String[] args) {
		EscapeALargeMaze test = new EscapeALargeMaze();
		System.out.println(test.isEscapePossible(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}, new int[] { 0, 0 }, new int[] { 0, 2 }));
	}

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		Set<String> blockedSet = new HashSet<>();
		for (int[] block : blocked) {
			String key = block[0] + "," + block[1];
			blockedSet.add(key);
		}
		return this.dfs(blockedSet, source[0], source[1], target[0], target[1], new HashSet<>())
				&& this.dfs(blockedSet, target[0], target[1], source[0], source[1], new HashSet<>());
	}

	private boolean dfs(Set<String> blocked, int sourceX, int sourceY, int targetX, int targetY, Set<String> visited) {
		visited.add(sourceX + "," + sourceY);
		if (sourceX == targetX && sourceY == targetY || visited.size() >= 20000) {
			return true;
		}
		for (int[] next : new int[][] {
			{ sourceX - 1, sourceY },
			{ sourceX + 1, sourceY },
			{ sourceX, sourceY - 1 },
			{ sourceX, sourceY + 1 }
		}) {
			String nextKey = next[0] + "," + next[1];
			if (next[0] >= 0 && next[1] >= 0 && next[0] < 1e6 && next[1] < 1e6 && !blocked.contains(nextKey)
					&& !visited.contains(nextKey) && this.dfs(blocked, next[0], next[1], targetX, targetY, visited)) {
				return true;
			}
		}
		return false;
	}

}
