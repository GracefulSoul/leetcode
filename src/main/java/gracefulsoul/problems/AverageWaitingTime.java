package gracefulsoul.problems;

public class AverageWaitingTime {

	// https://leetcode.com/problems/average-waiting-time/submissions/1314956293/
	public static void main(String[] args) {
		AverageWaitingTime test = new AverageWaitingTime();
		System.out.println(test.averageWaitingTime(new int[][] {
			{ 1, 2 },
			{ 2, 5 },
			{ 4, 3 }
		}));
		System.out.println(test.averageWaitingTime(new int[][] {
			{ 5, 2 },
			{ 5, 4 },
			{ 10, 3 },
			{ 20, 1 }
		}));
	}

	public double averageWaitingTime(int[][] customers) {
		int time = 0;
		double wait = 0;
		for (int[] customer : customers) {
			time = Math.max(time, customer[0]) + customer[1];
			wait += time - customer[0];
		}
		return wait / customers.length;
	}

}
