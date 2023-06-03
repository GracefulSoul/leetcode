package gracefulsoul.problems;

public class TimeNeededToInformAllEmployees {

	// https://leetcode.com/problems/time-needed-to-inform-all-employees/submissions/962671376/
	public static void main(String[] args) {
		TimeNeededToInformAllEmployees test = new TimeNeededToInformAllEmployees();
		System.out.println(test.numOfMinutes(1, 0, new int[] { -1 }, new int[] { 0 }));
		System.out.println(test.numOfMinutes(6, 2, new int[] { 2, 2, -1, 2, 2, 2 }, new int[] { 0, 0, 1, 0, 0, 0 }));
	}

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, this.dfs(manager, informTime, i));
		}
		return result;
	}

	private int dfs(int[] manager, int[] informTime, int i) {
		if (manager[i] != -1) {
			informTime[i] += this.dfs(manager, informTime, manager[i]);
			manager[i] = -1;
		}
		return informTime[i];
	}

}
