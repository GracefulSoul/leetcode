package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesToCleanTheClassroom {

	// https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/submissions/2127146224/
	public static void main(String[] args) {
		MinimumMovesToCleanTheClassroom test = new MinimumMovesToCleanTheClassroom();
		System.out.println(test.minMoves(new String[] { "S.", "XL" }, 2));
		System.out.println(test.minMoves(new String[] { "LS", "RL" }, 4));
		System.out.println(test.minMoves(new String[] { "L.S", "RXL" }, 3));
	}

	private static final int[] DIRECTIONS = { -1, 0, 1, 0, -1 };

	public int minMoves(String[] classroom, int energy) {
		int rows = classroom.length;
		int cols = classroom[0].length();
		int[][] map = new int[rows][cols];
		int[] start = new int[] { -1, -1 };
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				char c = classroom[i].charAt(j);
				if (c == 'S') {
					start[0] = i;
					start[1] = j;
				} else if (c == 'L') {
					map[i][j] = count++;
				}
			}
		}
		if (count == 0) {
			return 0;
		}
		int target = (1 << count) - 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start[0], start[1], energy, 0, 0 });
		boolean[][][][] visited = new boolean[rows][cols][energy + 1][1 << count];
		visited[start[0]][start[1]][energy][0] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + DIRECTIONS[i];
				int nc = curr[1] + DIRECTIONS[i + 1];
				if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && classroom[nr].charAt(nc) != 'X') {
					int ne = curr[2] - 1;
					int nm = curr[3];
					char nextCell = classroom[nr].charAt(nc);
					if (nextCell == 'L') {
						nm |= (1 << map[nr][nc]);
					}
					if (nm == target) {
						return curr[4] + 1;
					}
					if (nextCell == 'R') {
						ne = energy;
					}
					if (ne == 0 && nextCell != 'R') {
						continue;
					}
					if (!visited[nr][nc][ne][nm]) {
						visited[nr][nc][ne][nm] = true;
						queue.offer(new int[] { nr, nc, ne, nm, curr[4] + 1 });
					}
				}
			}
		}
		return -1;
	}

}
