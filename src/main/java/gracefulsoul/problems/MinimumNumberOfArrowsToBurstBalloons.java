package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

	// https://leetcode.com/submissions/detail/677980380/
	public static void main(String[] args) {
		MinimumNumberOfArrowsToBurstBalloons test = new MinimumNumberOfArrowsToBurstBalloons();
		System.out.println(test.findMinArrowShots(new int[][] {
			{ 10, 16 },
			{ 2, 8 },
			{ 1, 6 },
			{ 7, 12 }
		}));
		System.out.println(test.findMinArrowShots(new int[][] {
			{ 1, 2 },
			{ 3, 4 },
			{ 5, 6 },
			{ 7, 8 }
		}));
		System.out.println(test.findMinArrowShots(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 4, 5 }
		}));
	}

	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
		int point = points[0][1];
		int count = 1;
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > point) {
				point = points[i][1];
				count++;
			}
		}
		return count;
	}

}
