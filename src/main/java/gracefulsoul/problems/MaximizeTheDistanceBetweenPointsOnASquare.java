package gracefulsoul.problems;

import java.util.Arrays;

public class MaximizeTheDistanceBetweenPointsOnASquare {

	// https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/submissions/1987368960/
	public static void main(String[] args) {
		MaximizeTheDistanceBetweenPointsOnASquare test = new MaximizeTheDistanceBetweenPointsOnASquare();
		System.out.println(test.maxDistance(2, new int[][] {
			{ 0, 2 },
			{ 2, 0 },
			{ 2, 2 },
			{ 0, 0 }
		}, 4));
		System.out.println(test.maxDistance(2, new int[][] {
			{ 0, 0 },
			{ 1, 2 },
			{ 2, 0 },
			{ 2, 2 },
			{ 2, 1 }
		}, 4));
		System.out.println(test.maxDistance(2, new int[][] {
			{ 0, 0 },
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 2 },
			{ 2, 0 },
			{ 2, 2 },
			{ 2, 1 }
		}, 5));
	}

	public int maxDistance(int side, int[][] points, int k) {
		long perimeter = 4L * side;
		int length = points.length;
		long[] position = new long[length];
		for (int i = 0; i < length; i++) {
			long x = points[i][0], y = points[i][1];
			if (y == 0) {
				position[i] = x;
			} else if (x == side) {
				position[i] = side + y;
			} else if (y == side) {
				position[i] = 3L * side - x;
			} else {
				position[i] = 4L * side - y;
			}
		}
		Arrays.sort(position);
		long[] doubled = new long[2 * length];
		for (int i = 0; i < length; i++) {
			doubled[i] = position[i];
			doubled[i + length] = position[i] + perimeter;
		}
		long low = 1;
		long high = 2L * side;
		long result = 0;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (this.canPlace(doubled, k, perimeter, mid, length)) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (int) result;
	}

	private boolean canPlace(long[] doubled, int k, long perimeter, long distance, int length) {
		for (int i = 0; i < length; i++) {
			int count = 1;
			long curr = doubled[i];
			long limit = doubled[i] + perimeter - distance;
			int index = i;
			while (true) {
				int low = index + 1;
				int high = 2 * length - 1;
				int next = 2 * length;
				while (low <= high) {
					int mid = low + (high - low) / 2;
					if (doubled[mid] >= curr + distance) {
						next = mid;
						high = mid - 1;
					} else
						low = mid + 1;
				}
				if (next >= 2 * length || doubled[next] > limit) {
					break;
				}
				curr = doubled[next];
				index = next;
				if (++count == k) {
					return true;
				}
			}
		}
		return false;
	}

}
