package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {

	// https://leetcode.com/submissions/detail/698064808/
	public static void main(String[] args) {
		IncreasingSubsequences test = new IncreasingSubsequences();
		System.out.println(test.findSubsequences(new int[] { 4, 6, 7, 7 }));
		System.out.println(test.findSubsequences(new int[] { 4, 4, 3, 2, 1 }));
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		this.dfs(nums, result, new ArrayList<>(), 0, Integer.MIN_VALUE);
		return result;
	}

	private void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, int index, int value) {
		if (index == nums.length) {
			if (temp.size() >= 2) {
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		if (nums[index] >= value) {
			temp.add(nums[index]);
			this.dfs(nums, result, temp, index + 1, nums[index]);
			temp.remove(temp.size() - 1);
		}
		if (nums[index] != value) {
			this.dfs(nums, result, temp, index + 1, value);
		}
	}

}
