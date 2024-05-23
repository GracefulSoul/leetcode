package gracefulsoul.problems;

import java.util.Arrays;

public class TheNumberOfBeautifulSubsets {

	// https://leetcode.com/problems/the-number-of-beautiful-subsets/submissions/1265713869/
	public static void main(String[] args) {
		TheNumberOfBeautifulSubsets test = new TheNumberOfBeautifulSubsets();
		System.out.println(test.beautifulSubsets(new int[] { 2, 4, 6 }, 2));
		System.out.println(test.beautifulSubsets(new int[] { 1 }, 1));
	}

	public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		return this.dfs(nums, k, new int[1001], 0, 0);
	}

	private int dfs(int[] nums, int k, int[] freqMap, int i, int count) {
		for (int j = i; j < nums.length; j++) {
			if (nums[j] > k && freqMap[nums[j] - k] > 0) {
				continue;
			}
			freqMap[nums[j]]++;
			count = this.dfs(nums, k, freqMap, j + 1, count + 1);
			freqMap[nums[j]]--;
		}
		return count;
	}

}
