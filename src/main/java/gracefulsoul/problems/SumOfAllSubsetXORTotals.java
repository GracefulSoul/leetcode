package gracefulsoul.problems;

public class SumOfAllSubsetXORTotals {

	// https://leetcode.com/problems/sum-of-all-subset-xor-totals/submissions/1262927891/
	public static void main(String[] args) {
		SumOfAllSubsetXORTotals test = new SumOfAllSubsetXORTotals();
		System.out.println(test.subsetXORSum(new int[] { 1, 3 }));
		System.out.println(test.subsetXORSum(new int[] { 5, 1, 6 }));
		System.out.println(test.subsetXORSum(new int[] { 3, 4, 5, 6, 7, 8 }));
	}

	public int subsetXORSum(int[] nums) {
		return this.dfs(nums, 0, 0);
	}

	private int dfs(int[] nums, int index, int curr) {
		if (index == nums.length) {
			return curr;
		} else {
			return this.dfs(nums, index + 1, curr ^ nums[index]) + this.dfs(nums, index + 1, curr);
		}
	}

}
