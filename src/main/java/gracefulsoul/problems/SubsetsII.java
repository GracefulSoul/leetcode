package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	// https://leetcode.com/submissions/detail/519623450/
	public static void main(String[] args) {
		SubsetsII test = new SubsetsII();
		System.out.println(test.subsetsWithDup(new int[] { 1, 2, 2 }));
		System.out.println(test.subsetsWithDup(new int[] { 0 }));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void recursive(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
		result.add(new ArrayList<>(temp));
		for (int idx = start; idx < nums.length; idx++) {
			if (idx > start && nums[idx] == nums[idx - 1]) {
				continue;
			}
			temp.add(nums[idx]);
			this.recursive(result, temp, nums, idx + 1);
			temp.remove(temp.size() - 1);
		}
	}

}
