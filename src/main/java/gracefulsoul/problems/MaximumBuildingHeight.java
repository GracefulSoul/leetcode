package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumBuildingHeight {

	// https://leetcode.com/problems/maximum-building-height/submissions/2039219631/
	public static void main(String[] args) {
		MaximumBuildingHeight test = new MaximumBuildingHeight();
		System.out.println(test.maxBuilding(5, new int[][] {
			{ 2, 1 },
			{ 4, 1 }
		}));
		System.out.println(test.maxBuilding(6, new int[][] {
		}));
		System.out.println(test.maxBuilding(10, new int[][] {
			{ 5, 3 },
			{ 2, 5 },
			{ 7, 4 },
			{ 10, 3 }
		}));
	}

	public int maxBuilding(int n, int[][] restrictions) {
		Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));
		int[] prev = new int[] { 1, 0 };
		for (int[] restriction : restrictions) {
			restriction[1] = Math.min(restriction[1], prev[1] + restriction[0] - prev[0]);
			prev = restriction;
		}
		for (int i = restrictions.length - 2; i >= 0; i--) {
			restrictions[i][1] = Math.min(restrictions[i][1],
					restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
		}
		int min = Math.min(n - 1, prev[1] + n - prev[0]);
		int result = 0;
		prev = new int[] { 1, 0 };
		for (int[] restriction : restrictions) {
			result = Math.max(result, Math.max(prev[1], restriction[1])
					+ (restriction[0] - prev[0] - Math.abs(restriction[1] - prev[1])) / 2);
			prev = restriction;
		}
		result = Math.max(result, Math.max(prev[1], min) + (n - prev[0] - Math.abs(min - prev[1])) / 2);
		return result;
	}

}
