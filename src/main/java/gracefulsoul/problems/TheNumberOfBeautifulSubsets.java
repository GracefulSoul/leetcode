package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheNumberOfBeautifulSubsets {

	// https://leetcode.com/problems/the-number-of-beautiful-subsets/submissions/1265663645/
	public static void main(String[] args) {
		TheNumberOfBeautifulSubsets test = new TheNumberOfBeautifulSubsets();
		System.out.println(test.beautifulSubsets(new int[] { 2, 4, 6 }, 2));
		System.out.println(test.beautifulSubsets(new int[] { 1 }, 1));
	}

	public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		return this.dfs(nums, k, 0, new HashSet<Integer>());
	}

	private int dfs(int[] nums, int k, int i, Set<Integer> set) {
		if (i == nums.length) {
			return set.isEmpty() ? 0 : 1;
		} else {
			int count = this.dfs(nums, k, i + 1, set);
			if (!set.contains(nums[i] - k)) {
				set.add(nums[i]);
				count += this.dfs(nums, k, i + 1, set);
				set.remove(nums[i]);
			}
			return count;
		}
	}

}
