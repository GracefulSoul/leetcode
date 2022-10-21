package gracefulsoul.problems;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

	// https://leetcode.com/submissions/detail/827259091/
	public static void main(String[] args) {
		PartitionToKEqualSumSubsets test = new PartitionToKEqualSumSubsets();
		System.out.println(test.canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
		System.out.println(test.canPartitionKSubsets(new int[] { 1, 2, 3, 4 }, 3));
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();
		if (sum % k != 0 || nums[nums.length - 1] > sum / k) {
			return false;
		}
		int[] bucket = new int[k];
		int target = sum / k;
		return this.dfs(nums, target, bucket, nums.length - 1);
	}

	private boolean dfs(int nums[], int target, int[] bucket, int index) {
		if (index == -1) {
			return true;
		}
		for (int i = 0; i < bucket.length; i++) {
			if ((nums[index] + bucket[i] > target) || (i > 0 && bucket[i] == bucket[i - 1])) {
				continue;
			}
			bucket[i] += nums[index];
			if (this.dfs(nums, target, bucket, index - 1)) {
				return true;
			}
			bucket[i] -= nums[index];
			if (bucket[i] == 0) {
				break;
			}
		}
		return false;
	}

}
