package gracefulsoul.problems;

public class StoneGameIII {

	// https://leetcode.com/problems/stone-game-iii/submissions/2092537968/
	public static void main(String[] args) {
		StoneGameIII test = new StoneGameIII();
		System.out.println(test.stoneGameIII(new int[] { 1, 2, 3, 7 }));
		System.out.println(test.stoneGameIII(new int[] { 1, 2, 3, -9 }));
		System.out.println(test.stoneGameIII(new int[] { 1, 2, 3, 6 }));
	}

	public String stoneGameIII(int[] stoneValue) {
		int length = stoneValue.length;
		int[] dp = new int[4];
		for (int i = length - 1; i >= 0; i--) {
			dp[i % 4] = Integer.MIN_VALUE;
			for (int j = 0, k = 0; j < 3 && i + j < length; j++) {
				k += stoneValue[i + j];
				dp[i % 4] = Math.max(dp[i % 4], k - dp[(i + j + 1) % 4]);
			}
		}
		if (dp[0] > 0) {
			return "Alice";
		} else if (dp[0] < 0) {
			return "Bob";
		} else {
			return "Tie";
		}
	}

}
