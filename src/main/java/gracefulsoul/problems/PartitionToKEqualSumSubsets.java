package gracefulsoul.problems;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

	// https://leetcode.com/submissions/detail/827620530/
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
		return this.dfs(nums, sum / k, new int[k], nums.length - 1);
	}

	private boolean dfs(int nums[], int target, int[] bucket, int index) {
		if (index == -1) {
			return true;
		}
		for (int idx = 0; idx < bucket.length; idx++) {
			if ((nums[index] + bucket[idx] > target) || (idx > 0 && bucket[idx] == bucket[idx - 1])) {
				continue;
			}
			bucket[idx] += nums[index];
			if (this.dfs(nums, target, bucket, index - 1)) {
				return true;
			}
			bucket[idx] -= nums[index];
			if (bucket[idx] == 0) {
				break;
			}
		}
		return false;
	}

}
