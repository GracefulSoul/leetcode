package gracefulsoul.problems;

public class SuperEggDrop {

	// https://leetcode.com/problems/super-egg-drop/submissions/923645751/
	public static void main(String[] args) {
		SuperEggDrop test = new SuperEggDrop();
		System.out.println(test.superEggDrop(1, 2));
		System.out.println(test.superEggDrop(2, 6));
		System.out.println(test.superEggDrop(3, 14));
	}

	public int superEggDrop(int k, int n) {
		int[][] dp = new int[n + 1][k + 1];
		int i = 0;
		while (dp[i][k] < n) {
			i++;
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
			}
		}
		return i;
	}

}
