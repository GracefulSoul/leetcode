package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathToGetAllKeys {

	// https://leetcode.com/problems/shortest-path-to-get-all-keys/submissions/910760648/
	public static void main(String[] args) {
		ShortestPathToGetAllKeys test = new ShortestPathToGetAllKeys();
		System.out.println(test.shortestPathAllKeys(new String[] { "@.a..", "###.#", "b.A.B" }));
		System.out.println(test.shortestPathAllKeys(new String[] { "@..aA", "..B#.", "....b" }));
		System.out.println(test.shortestPathAllKeys(new String[] { "@Aa" }));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 0, -1 },
		{ -1, 0 },
		{ 1, 0 }
	};

	public int shortestPathAllKeys(String[] grid) {
		int row = grid.length;
		int col = grid[0].length();
		boolean[][][] visited = new boolean[row][col][1 << 6];
		Queue<Integer> queue = new ArrayDeque<>();
		int allKeys = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char c = grid[i].charAt(j);
				if (c == '@') {
					queue.add((i << 16) | (j << 8));
					visited[i][j][0] = true;
				} else if (c >= 'a' && c <= 'f') {
					allKeys |= (1 << (c - 'a'));
				}
			}
		}
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int curr = queue.poll();
				int x = curr >> 16;
				int y = (curr >> 8) & 0xFF;
				int keys = curr & 0xFF;
				if (keys == allKeys) {
					return steps;
				}
				for (int[] direction : DIRECTIONS) {
					int nx = direction[0] + x;
					int ny = direction[1] + y;
					int nKeys = keys;
					if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny][nKeys]) {
						continue;
					}
					char c = grid[nx].charAt(ny);
					if (c == '#' || ((c >= 'A' && c <= 'F') && ((keys & (1 << (c - 'A'))) != (1 << (c - 'A'))))) {
						continue;
					}
					if (c >= 'a' && c <= 'f') {
						nKeys = keys | (1 << (c - 'a'));
					}
					queue.add((nx << 16) | (ny << 8) | nKeys);
					visited[nx][ny][nKeys] = true;
				}
			}
			steps++;
		}
		return -1;
	}

}
