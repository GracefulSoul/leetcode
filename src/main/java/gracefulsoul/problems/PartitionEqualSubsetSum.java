package gracefulsoul.problems;

public class PartitionEqualSubsetSum {

	// https://leetcode.com/submissions/detail/1599468944/
	public static void main(String[] args) {
		PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
		System.out.println(test.canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(test.canPartition(new int[] { 1, 2, 3, 5 }));
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		} else {
			sum /= 2;
			return canPartition(nums, nums.length - 1, new Boolean[sum + 1], sum);
		}
	}

	private Boolean canPartition(int[] nums, int index, Boolean[] memo, int sum) {
		if (sum == 0) {
			return true;
		} else if (sum < 0) {
			return false;
		} else if (index == 0) {
			return sum == nums[0];
		} else if (memo[sum] != null) {
			return memo[sum];
		} else {
			memo[sum] = this.canPartition(nums, index - 1, memo, sum - nums[index]) || this.canPartition(nums, index - 1, memo, sum);
			return memo[sum];
		}
	}

}
