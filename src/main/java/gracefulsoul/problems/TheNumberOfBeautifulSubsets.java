package gracefulsoul.problems;

import java.util.Arrays;

public class TheNumberOfBeautifulSubsets {

	// https://leetcode.com/problems/the-number-of-beautiful-subsets/submissions/1265718820/
	public static void main(String[] args) {
		TheNumberOfBeautifulSubsets test = new TheNumberOfBeautifulSubsets();
		System.out.println(test.beautifulSubsets(new int[] { 2, 4, 6 }, 2));
		System.out.println(test.beautifulSubsets(new int[] { 1 }, 1));
	}

	public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		return this.dfs(nums, k, new int[1001], 0, 0);
	}

	private int dfs(int[] nums, int k, int[] counts, int i, int count) {
		for (int j = i; j < nums.length; j++) {
			if (nums[j] <= k || counts[nums[j] - k] == 0) {
				counts[nums[j]]++;
				count = this.dfs(nums, k, counts, j + 1, count + 1);
				counts[nums[j]]--;
			}
		}
		return count;
	}

}
