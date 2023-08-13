package gracefulsoul.problems;

public class CheckIfThereIsAValidPartitionForTheArray {

	// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/submissions/1019693566/
	public static void main(String[] args) {
		CheckIfThereIsAValidPartitionForTheArray test = new CheckIfThereIsAValidPartitionForTheArray();
		System.out.println(test.validPartition(new int[] { 4, 4, 4, 5, 6 }));
		System.out.println(test.validPartition(new int[] { 1, 1, 1, 2 }));
	}

	public boolean validPartition(int[] nums) {
		int length = nums.length;
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 2; i <= length; i++) {
			dp[i] |= nums[i - 1] == nums[i - 2] && dp[i - 2];
			dp[i] |= i > 2 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3];
			dp[i] |= i > 2 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1 && dp[i - 3];
		}
		return dp[length];
	}

}
