package gracefulsoul.problems;

public class DeleteAndEarn {

	// https://leetcode.com/submissions/detail/851530240/
	public static void main(String[] args) {
		DeleteAndEarn test = new DeleteAndEarn();
		System.out.println(test.deleteAndEarn(new int[] { 3, 4, 2 }));
		System.out.println(test.deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
	}

	public int deleteAndEarn(int[] nums) {
		int[] dp = new int[10001];
		int max = 0;
		for (int num : nums) {
			dp[num] = dp[num] + num;
			max = Math.max(num, max);
		}
		for (int idx = 2; idx <= max; idx++) {
			dp[idx] = Math.max(dp[idx - 1], dp[idx] + dp[idx - 2]);
		}
		return dp[max];
	}

}
