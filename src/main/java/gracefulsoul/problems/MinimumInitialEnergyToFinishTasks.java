package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {

	// https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/submissions/2001259208/
	public static void main(String[] args) {
		MinimumInitialEnergyToFinishTasks test = new MinimumInitialEnergyToFinishTasks();
		System.out.println(test.minimumEffort(new int[][] {
			{ 1, 2 },
			{ 2, 4 },
			{ 4, 8 }
		}));
		System.out.println(test.minimumEffort(new int[][] {
			{ 1, 3 },
			{ 2, 4 },
			{ 10, 11 },
			{ 10, 12 },
			{ 8, 9 }
		}));
		System.out.println(test.minimumEffort(new int[][] {
			{ 1, 7 },
			{ 2, 8 },
			{ 3, 9 },
			{ 4, 10 },
			{ 5, 11 },
			{ 6, 12 }
		}));
	}

	public int minimumEffort(int[][] tasks) {
		int result = 0;
		Arrays.sort(tasks, (a1, a2) -> (a1[1] - a1[0]) - (a2[1] - a2[0]));
		for (int[] a : tasks) {
			result = Math.max(result + a[0], a[1]);
		}
		return result;
	}

}
