package gracefulsoul.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

	// https://leetcode.com/problems/sliding-puzzle/submissions/863014070/
	public static void main(String[] args) {
		SlidingPuzzle test = new SlidingPuzzle();
		System.out.println(test.slidingPuzzle(new int[][] {
			{ 1, 2, 3 },
			{ 4, 0, 5 }
		}));
		System.out.println(test.slidingPuzzle(new int[][] {
			{ 1, 2, 3 },
			{ 5, 4, 0 }
		}));
		System.out.println(test.slidingPuzzle(new int[][] {
			{ 4, 1, 2 },
			{ 5, 0, 3 }
		}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 1, 3 },
		{ 0, 2, 4 },
		{ 1, 5 }, { 0, 4 },
		{ 1, 3, 5 },
		{ 2, 4 }
	};

	public int slidingPuzzle(int[][] board) {
		String target = "123450";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
		}
		String start = sb.toString();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int idx = 0; idx < size; idx++) {
				String curr = queue.poll();
				if (curr.equals(target)) {
					return result;
				}
				int index = curr.indexOf('0');
				for (int dir : DIRECTIONS[index]) {
					String next = this.swap(curr, index, dir);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					queue.offer(next);
				}
			}
			result++;
		}
		return -1;
	}

	private String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		return sb.toString();
	}

}
