package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

	// https://leetcode.com/problems/k-closest-points-to-origin/submissions/1018939783/
	public static void main(String[] args) {
		KClosestPointsToOrigin test = new KClosestPointsToOrigin();
		System.out.println(test.kClosest(new int[][] {
			{ 1, 3 },
			{ -2, 2 }
		}, 1));
		System.out.println(test.kClosest(new int[][] {
			{ 3, 3 },
			{ 5, -1 },
			{ -2, 4 }
		}, 2));
	}

	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
		int[][] result = new int[k][2];
		for (int[] point : points) {
			queue.add(point);
		}
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll();
		}
		return result;
	}

}
