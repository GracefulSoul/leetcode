package gracefulsoul.problems;

public class MinimumTimeVisitingAllPoints {

	// https://leetcode.com/problems/minimum-time-visiting-all-points/submissions/1111143082/
	public static void main(String[] args) {
		MinimumTimeVisitingAllPoints test = new MinimumTimeVisitingAllPoints();
		System.out.println(test.minTimeToVisitAllPoints(new int[][] {
			{ 1, 1 },
			{ 3, 4 },
			{ -1, 0 }
		}));
		System.out.println(test.minTimeToVisitAllPoints(new int[][] {
			{ 3, 2 },
			{ -2, 2 }
		}));
	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int result = 0;
		for (int i = 1; i < points.length; i++) {
			int[] curr = points[i];
			int[] prev = points[i - 1];
			result += Math.max(Math.abs(curr[0] - prev[0]), Math.abs(curr[1] - prev[1]));
		}
		return result;
	}

}
