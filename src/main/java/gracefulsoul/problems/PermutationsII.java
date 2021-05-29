package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

	// https://leetcode.com/submissions/detail/499636002/
	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		print(test.permuteUnique(new int[] { 1, 1, 2 }));
		print(test.permuteUnique(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		this.swap(nums);
		this.getPermutations(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	private void getPermutations(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] usable) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		} else {
			for (int idx = 0; idx < nums.length; idx++) {
				if (usable[idx] || (idx > 0 && nums[idx - 1] == nums[idx] && !usable[idx - 1])) {
					continue;
				}
				list.add(nums[idx]);
				usable[idx] = true;
				this.getPermutations(result, list, nums, usable);
				usable[idx] = false;
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

	private static void print(List<List<Integer>> list) {
		System.out.println(list);
	}

}
