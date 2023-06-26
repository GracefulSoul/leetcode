package gracefulsoul.problems;

public class CountAllPossibleRoutes {

	// https://leetcode.com/problems/count-all-possible-routes/submissions/979261966/
	public static void main(String[] args) {
		CountAllPossibleRoutes test = new CountAllPossibleRoutes();
		System.out.println(test.countRoutes(new int[] { 2, 3, 6, 8, 4 }, 1, 3, 5));
		System.out.println(test.countRoutes(new int[] { 4, 3, 1 }, 1, 0, 6));
		System.out.println(test.countRoutes(new int[] { 5, 2, 1 }, 0, 2, 3));
	}

	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		return this.dfs(locations, start, finish, fuel, new Integer[locations.length][fuel + 1]);
	}

	private int dfs(int[] locations, int index, int finish, int fuel, Integer dp[][]) {
		if (dp[index][fuel] != null) {
			return dp[index][fuel];
		}
		int result = index == finish ? 1 : 0;
		for (int i = 0; i < locations.length; i++) {
			if (i == index) {
				continue;
			}
			int f = Math.abs(locations[index] - locations[i]);
			if (fuel - f >= 0) {
				result = (result + this.dfs(locations, i, finish, fuel - f, dp)) % 1000000007;
			}
		}
		return dp[index][fuel] = result;
	}

}
