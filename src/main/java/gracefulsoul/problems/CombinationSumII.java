package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	// https://leetcode.com/submissions/detail/496056832/
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		print(test.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		print(test.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		this.getCombination(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	private void getCombination(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
		} else if (target > 0) {
			for (int idx = start; idx < candidates.length; idx++) {
				if (idx > start && candidates[idx - 1] == candidates[idx]) {
					continue;
				}
				list.add(candidates[idx]);
				this.getCombination(result, list, candidates, target - candidates[idx], idx + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private static void print(List<List<Integer>> list) {
		for (List<Integer> data : list) {
			System.out.println(data.toString());
		}
	}

}
