package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class Permutations {

	// https://leetcode.com/submissions/detail/499405241/
	public static void main(String[] args) {
		Permutations test = new Permutations();
		PrintUtil.print(test.permute(new int[] { 1, 2, 3 }));
		PrintUtil.print(test.permute(new int[] { 0, 1 }));
		PrintUtil.print(test.permute(new int[] { 1 }));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		this.getPermutations(result, new ArrayList<>(), nums);
		return result;
	}

	private void getPermutations(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		} else {
			for (int idx = 0; idx < nums.length; idx++) {
				if (list.contains(nums[idx])) {
					continue;
				}
				list.add(nums[idx]);
				this.getPermutations(result, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}

}
