package gracefulsoul.problems;

public class ContinuousSubarraySum {

	// https://leetcode.com/submissions/detail/718024868/
	public static void main(String[] args) {
		ContinuousSubarraySum test = new ContinuousSubarraySum();
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 13));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		int length = nums.length;
		int sum = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			if (nums[i] == 0 && nums[i + 1] == 0) {
				return true;
			} else {
				sum += nums[i];
			}
			if (sum == 0 || sum >= k) {
				int subSum = nums[i];
				for (int j = i + 1; j < length; j++) {
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
