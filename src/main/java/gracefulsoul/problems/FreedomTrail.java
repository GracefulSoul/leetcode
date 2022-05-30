package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FreedomTrail {

	// https://leetcode.com/submissions/detail/710331696/
	public static void main(String[] args) {
		FreedomTrail test = new FreedomTrail();
		System.out.println(test.findRotateSteps("godding", "gd"));
		System.out.println(test.findRotateSteps("godding", "godding"));
	}

	@SuppressWarnings("unchecked")
	public int findRotateSteps(String ring, String key) {
		int length = ring.length();
		List<Integer>[] position = new ArrayList[26];
		int[][] dp = new int[length][key.length()];
		for (int idx = 0; idx < 26; idx++) {
			position[idx] = new ArrayList<>();
		}
		for (int idx = 0; idx < length; idx++) {
			position[ring.charAt(idx) - 'a'].add(idx);
		}
		return this.dfs(position, dp, ring, length, key, 0, 0);
	}

	private int dfs(List<Integer>[] position, int[][] dp, String ring, int length, String key, int x, int y) {
		if (y == key.length()) {
			return 0;
		} else if (dp[x][y] != 0) {
			return dp[x][y];
		} else {
			int result = Integer.MAX_VALUE;
			for (int num : position[key.charAt(y) - 'a']) {
				int diff = Math.abs(x - num);
				result = Math.min(result,
						Math.min(diff, length - diff) + this.dfs(position, dp, ring, length, key, num, y + 1));
			}
			dp[x][y] = result + 1;
			return result + 1;
		}
	}

}
