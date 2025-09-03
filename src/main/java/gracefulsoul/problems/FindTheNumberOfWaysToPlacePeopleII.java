package gracefulsoul.problems;

import java.util.Arrays;

public class FindTheNumberOfWaysToPlacePeopleII {

	// https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/submissions/1758324784/
	public static void main(String[] args) {
		FindTheNumberOfWaysToPlacePeopleII test = new FindTheNumberOfWaysToPlacePeopleII();
		System.out.println(test.numberOfPairs(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 }
		}));
		System.out.println(test.numberOfPairs(new int[][] {
			{ 6, 2 },
			{ 4, 4 },
			{ 2, 6 }
		}));
		System.out.println(test.numberOfPairs(new int[][] {
			{ 3, 1 },
			{ 1, 3 },
			{ 1, 1 }
		}));
	}

	public int numberOfPairs(int[][] points) {
		int result = 0;
		int length = points.length;
		Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		for (int i = 0; i < length; i++) {
			int[] a = points[i];
			int y = Integer.MIN_VALUE;
			for (int j = i + 1; j < length; j++) {
				int[] b = points[j];
				if (b[1] <= a[1] && y < b[1]) {
					result++;
					y = b[1];
				}
			}
		}
		return result;
	}

}
