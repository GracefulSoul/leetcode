package gracefulsoul.problems;

public class CanIWin {

	// https://leetcode.com/submissions/detail/685712393/
	public static void main(String[] args) {
		CanIWin test = new CanIWin();
		System.out.println(test.canIWin(10, 11));
		System.out.println(test.canIWin(10, 0));
		System.out.println(test.canIWin(10, 1));
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
			return false;
		} else if (maxChoosableInteger >= desiredTotal) {
			return true;
		} else {
			return this.dfs(maxChoosableInteger, desiredTotal, new boolean[1 << maxChoosableInteger], 0);
		}
	}

	private boolean dfs(int maxChoosableInteger, int desiredTotal, boolean[] dp, int curr) {
		if (dp[curr]) {
			return dp[curr];
		}
		for (int idx = 0; idx < maxChoosableInteger; idx++) {
			if ((curr & 1 << idx) != 0) {
				continue;
			} else if (idx + 1 >= desiredTotal || !this.dfs(maxChoosableInteger, desiredTotal - idx - 1, dp, curr | 1 << idx)) {
				dp[curr] = true;
				return true;
			}
		}
		return false;
	}

}
