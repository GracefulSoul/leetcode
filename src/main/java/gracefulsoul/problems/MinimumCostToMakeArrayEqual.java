package gracefulsoul.problems;

public class MinimumCostToMakeArrayEqual {

	// https://leetcode.com/problems/minimum-cost-to-make-array-equal/submissions/976243888/
	public static void main(String[] args) {
		MinimumCostToMakeArrayEqual test = new MinimumCostToMakeArrayEqual();
		System.out.println(test.minCost(new int[] { 1, 3, 5, 2 }, new int[] { 2, 3, 1, 14 }));
		System.out.println(test.minCost(new int[] { 2, 2, 2, 2, 2 }, new int[] { 4, 2, 8, 1, 3 }));
	}

	public long minCost(int[] nums, int[] cost) {
		long left = 1L;
		long right = 1000000L;
		for (int num : nums) {
			left = Math.min(num, left);
			right = Math.max(num, right);
		}
		long result = 0;
		while (left < right) {
			long mid = left + ((right - left) / 2);
			long cost1 = this.getCost(nums, cost, mid);
			long cost2 = this.getCost(nums, cost, mid + 1);
			result = Math.min(cost1, cost2);
			if (cost1 < cost2) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	private long getCost(int[] nums, int[] cost, long x) {
		long sum = 0L;
		for (int i = 0; i < nums.length; i++) {
			sum += Math.abs(nums[i] - x) * cost[i];
		}
		return sum;
	}

}
