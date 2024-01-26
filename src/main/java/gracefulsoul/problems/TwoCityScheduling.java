package gracefulsoul.problems;

import java.util.Arrays;

public class TwoCityScheduling {

	// https://leetcode.com/problems/two-city-scheduling/submissions/1157330158/
	public static void main(String[] args) {
		TwoCityScheduling test = new TwoCityScheduling();
		System.out.println(test.twoCitySchedCost(new int[][] {
			{ 10, 20 },
			{ 30, 200 },
			{ 400, 50 },
			{ 30, 20 }
		}));
		System.out.println(test.twoCitySchedCost(new int[][] {
			{ 259, 770 },
			{ 448, 54 },
			{ 926, 667 },
			{ 184, 139 },
			{ 840, 118 },
			{ 577, 469 }
		}));
		System.out.println(test.twoCitySchedCost(new int[][] {
			{ 515, 563 },
			{ 451, 713 },
			{ 537, 709 },
			{ 343, 819 },
			{ 855, 779 },
			{ 457, 60 },
			{ 650, 359 },
			{ 631, 42 }
		}));
	}

	public int twoCitySchedCost(int[][] costs) {
		int length = costs.length / 2;
		int[] dp = new int[length * 2];
		int min = 0;
		int index = 0;
		for (int[] cost : costs) {
			dp[index++] = cost[1] - cost[0];
			min += cost[0];
		}
		Arrays.sort(dp);
		for (int i = 0; i < length; i++) {
			min += dp[i];
		}
		return min;
	}

}
