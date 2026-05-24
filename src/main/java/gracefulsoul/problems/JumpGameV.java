package gracefulsoul.problems;

public class JumpGameV {

	// https://leetcode.com/problems/jump-game-v/submissions/2011700967/
	public static void main(String[] args) {
		JumpGameV test = new JumpGameV();
		System.out.println(test.maxJumps(new int[] { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 }, 2));
		System.out.println(test.maxJumps(new int[] { 3, 3, 3, 3, 3 }, 3));
		System.out.println(test.maxJumps(new int[] { 7, 6, 5, 4, 3, 2, 1 }, 1));
	}

	public int maxJumps(int[] arr, int d) {
		int length = arr.length;
		int[] dp = new int[length];
		int result = 1;
		for (int i = 0; i < length; i++) {
			result = Math.max(result, this.dfs(arr, d, length, dp, i));
		}
		return result;
	}

	private int dfs(int[] arr, int d, int length, int[] dp, int i) {
		if (dp[i] != 0) {
			return dp[i];
		}
		int max = 1;
		for (int j = i + 1; j <= Math.min(i + d, length - 1) && arr[j] < arr[i]; ++j) {
			max = Math.max(max, 1 + dfs(arr, d, length, dp, j));
		}
		for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; --j) {
			max = Math.max(max, 1 + dfs(arr, d, length, dp, j));
		}
		return dp[i] = max;
	}

}
