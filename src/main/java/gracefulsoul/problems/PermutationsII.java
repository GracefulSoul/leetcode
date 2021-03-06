package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

	// https://leetcode.com/submissions/detail/499650179/
	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		System.out.println(test.permuteUnique(new int[] { 1, 1, 2 }));
		System.out.println(test.permuteUnique(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		this.swap(nums);
		this.getPermutations(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	private void getPermutations(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		} else {
			for (int idx = 0; idx < nums.length; idx++) {
				if (used[idx] || (idx > 0 && nums[idx - 1] == nums[idx] && !used[idx - 1])) {
					continue;
				}
				list.add(nums[idx]);
				used[idx] = true;
				this.getPermutations(result, list, nums, used);
				used[idx] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	private void swap(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}

}
