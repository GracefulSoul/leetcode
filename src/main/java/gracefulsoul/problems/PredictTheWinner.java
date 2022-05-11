package gracefulsoul.problems;

public class PredictTheWinner {

	// https://leetcode.com/submissions/detail/697149513/
	public static void main(String[] args) {
		PredictTheWinner test = new PredictTheWinner();
		System.out.println(test.PredictTheWinner(new int[] { 1, 5, 2 }));
		System.out.println(test.PredictTheWinner(new int[] { 1, 5, 233, 7 }));
	}

	public boolean PredictTheWinner(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (i == j) {
					dp[i] = nums[i];
				} else {
					dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
				}
			}
		}
		return dp[length - 1] >= 0;
	}

}
