package gracefulsoul.problems;

public class ContinuousSubarraySum {

	// https://leetcode.com/submissions/detail/718011272/
	public static void main(String[] args) {
		ContinuousSubarraySum test = new ContinuousSubarraySum();
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 13));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		int length = nums.length;
		int sum = nums[length - 1];
		for (int idx = length - 2; idx >= 0; idx--) {
			if (nums[idx] == 0 && nums[idx + 1] == 0) {
				return true;
			} else {
				sum += nums[idx];
			}
			if (sum >= k || sum == 0) {
				int subSum = nums[idx];
				for (int j = idx + 1; j < length; j++) {
					subSum += nums[j];
					if (subSum % k == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
