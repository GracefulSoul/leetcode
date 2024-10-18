package gracefulsoul.problems;

public class CountNumberOfMaximumBitwiseORSubsets {

	// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/submissions/1426306968/
	public static void main(String[] args) {
		CountNumberOfMaximumBitwiseORSubsets test = new CountNumberOfMaximumBitwiseORSubsets();
		System.out.println(test.countMaxOrSubsets(new int[] { 3, 1 }));
		System.out.println(test.countMaxOrSubsets(new int[] { 2, 2, 2 }));
		System.out.println(test.countMaxOrSubsets(new int[] { 3, 2, 1, 5 }));
	}

	public int countMaxOrSubsets(int[] nums) {
		int max = 0;
		for (int num : nums) {
			max |= num;
		}
		return this.dfs(nums, 0, 0, max);
	}

	private int dfs(int[] nums, int i, int num, int max) {
		if (i == nums.length) {
			return num == max ? 1 : 0;
		} else {
			return this.dfs(nums, i + 1, num | nums[i], max) + this.dfs(nums, i + 1, num, max);
		}
	}

}
