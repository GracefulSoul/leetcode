package gracefulsoul.problems;

public class LastStoneWeightII {

	// https://leetcode.com/problems/last-stone-weight-ii/submissions/1207110399/
	public static void main(String[] args) {
		LastStoneWeightII test = new LastStoneWeightII();
		System.out.println(test.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 }));
		System.out.println(test.lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 }));
	}

	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}
		int[] dp = new int[(sum / 2) + 1];
		for (int i = 0; i < stones.length; i++) {
			for (int j = sum / 2; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return sum - (2 * dp[sum / 2]);
	}

}
