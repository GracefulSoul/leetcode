package gracefulsoul.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumAveragePassRatio {

	// https://leetcode.com/problems/maximum-average-pass-ratio/submissions/1479096096/
	public static void main(String[] args) {
		MaximumAveragePassRatio test = new MaximumAveragePassRatio();
		System.out.println(test.maxAverageRatio(new int[][] {
			{ 1, 2 },
			{ 3, 5 },
			{ 2, 2 }
		}, 2));
		System.out.println(test.maxAverageRatio(new int[][] {
			{ 2, 4 },
			{ 3, 9 },
			{ 4, 5 },
			{ 2, 10 }
		}, 4));
	}

	public double maxAverageRatio(int[][] classes, int extraStudents) {
		Queue<double[]> queue = new PriorityQueue<>(Comparator.comparingDouble(c -> -c[2]));
		for (int[] c : classes) {
			double a = c[0];
			double b = c[1];
			queue.offer(new double[] { a, b, this.getRatio(a, b) });
		}
		while (extraStudents-- > 0) {
			double[] curr = queue.poll();
			double a = curr[0];
			double b = curr[1];
			queue.offer(new double[] { a + 1, b + 1, this.getRatio(a + 1, b + 1) });
		}
		double result = 0.0d;
		while (!queue.isEmpty()) {
			double[] curr = queue.poll();
			result += curr[0] / curr[1];
		}
		return result / classes.length;
	}

	private double getRatio(double a, double b) {
		return ((a + 1) / (b + 1)) - (a / b);
	}

}
