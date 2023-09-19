package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInAMatrix {

	// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/submissions/1053417948/
	public static void main(String[] args) {
		TheKWeakestRowsInAMatrix test = new TheKWeakestRowsInAMatrix();
		System.out.println(test.kWeakestRows(new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 1, 1, 1, 1, 0 },
			{ 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 }
		}, 3));
		System.out.println(test.kWeakestRows(new int[][] {
			{ 1, 0, 0, 0 },
			{ 1, 1, 1, 1 },
			{ 1, 0, 0, 0 },
			{ 1, 0, 0, 0 }
		}, 3));
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
		int[] result = new int[k];
		for (int i = 0; i < mat.length; i++) {
			queue.offer(new int[] { this.find(mat[i]), i });
			if (queue.size() > k) {
				queue.poll();
			}
		}
		while (k > 0) {
			result[--k] = queue.poll()[1];
		}
		return result;
	}

	private int find(int[] row) {
		int low = 0;
		int high = row.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (row[mid] == 1) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

}
