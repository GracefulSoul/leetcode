package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensThatCanAttackTheKing {

	// https://leetcode.com/problems/queens-that-can-attack-the-king/submissions/1492929507/
	public static void main(String[] args) {
		QueensThatCanAttackTheKing test = new QueensThatCanAttackTheKing();
		System.out.println(test.queensAttacktheKing(new int[][] {
			{ 0, 1 },
			{ 1, 0 },
			{ 4, 0 },
			{ 0, 4 },
			{ 3, 3 },
			{ 2, 4 }
		}, new int[] { 0, 0 }));
		System.out.println(test.queensAttacktheKing(new int[][] {
			{ 0, 0 },
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 4 },
			{ 3, 5 },
			{ 4, 4 },
			{ 4, 5 }
		}, new int[] { 3, 3 }));
	}

	private static final int[][] DIRECTIONS = {
		{ -1, -1 },
		{ 0, -1 },
		{ 1, -1 },
		{ 1, 0 },
		{ 1, 1 },
		{ 0, 1 },
		{ -1, 1 },
		{ -1, 0 }
	};

	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		boolean[][] visited = new boolean[8][8];
		for (int[] queen : queens) {
			visited[queen[0]][queen[1]] = true;
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int[] direction : DIRECTIONS) {
			for (int x = king[0] + direction[0], y = king[1] + direction[1];
					0 <= x && x < 8 && 0 <= y && y < 8; x += direction[0], y += direction[1]) {
				if (visited[x][y]) {
					result.add(Arrays.asList(x, y));
					break;
				}
			}
		}
		return result;
	}

}
