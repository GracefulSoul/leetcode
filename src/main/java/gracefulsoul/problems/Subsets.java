package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	// https://leetcode.com/submissions/detail/513738539/
	public static void main(String[] args) {
		Subsets test = new Subsets();
		System.out.println(test.subsets(new int[] { 1, 2, 3 }));
		System.out.println(test.subsets(new int[] { 0 }));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void recursive(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
		result.add(new ArrayList<>(temp));
		for (int idx = start; idx < nums.length; idx++) {
			temp.add(nums[idx]);
			this.recursive(result, temp, nums, idx + 1);
			temp.remove(temp.size() - 1);
		}
	}

}
