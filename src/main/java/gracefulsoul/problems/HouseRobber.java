package gracefulsoul.problems;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber test = new HouseRobber();
		System.out.println(test.rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(test.rob(new int[] { 2, 7, 9, 3, 1 }));
	}

	public int rob(int[] nums) {
		int length = nums.length;
		int[][] dp = new int[length + 1][2];
		for (int i = 0; i < length; i++) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
			dp[i + 1][1] = nums[i] + dp[i][0];
		}
		return Math.max(dp[length][0], dp[length][1]);
	}

}
