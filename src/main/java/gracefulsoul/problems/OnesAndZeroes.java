package gracefulsoul.problems;

public class OnesAndZeroes {

	// https://leetcode.com/submissions/detail/690123202/
	public static void main(String[] args) {
		OnesAndZeroes test = new OnesAndZeroes();
		System.out.println(test.findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
		System.out.println(test.findMaxForm(new String[] { "10", "0", "1" }, 1, 1));
	}

	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int[] count = new int[2];
			for (char c : s.toCharArray()) {
				if (c == '0') {
					count[0]++;
				} else {
					count[1]++;
				}
			}
			for (int i = m; i >= count[0]; i--) {
				for (int j = n; j >= count[1]; j--) {
					dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
				}
			}
		}
		return dp[m][n];
	}

}
