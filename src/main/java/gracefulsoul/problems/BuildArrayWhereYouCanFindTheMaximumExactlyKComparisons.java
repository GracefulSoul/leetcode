package gracefulsoul.problems;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

	// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/submissions/1069204447/
	public static void main(String[] args) {
		BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons test = new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons();
		System.out.println(test.numOfArrays(2, 3, 1));
		System.out.println(test.numOfArrays(5, 2, 3));
		System.out.println(test.numOfArrays(9, 1, 1));
	}

	public int numOfArrays(int n, int m, int k) {
		return this.dfs(n, m, k, 0, new Integer[n + 1][m + 1][k + 1], 0, 0);
	}

	private int dfs(int n, int m, int k, int i, Integer[][][] dp, int max, int cost) {
		if (i == n) {
			return k == cost ? 1 : 0;
		} else if (dp[i][max][cost] != null) {
			return dp[i][max][cost];
		} else {
			int result = 0;
			result += (long) max * this.dfs(n, m, k, i + 1, dp, max, cost) % 1_000_000_007;
			if (cost + 1 <= k) {
				for (int num = max + 1; num <= m; num++) {
					result += this.dfs(n, m, k, i + 1, dp, num, cost + 1);
					result %= 1000000007;
				}
			}
			return dp[i][max][cost] = result;
		}
	}

}
