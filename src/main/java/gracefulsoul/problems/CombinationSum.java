package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	// https://leetcode.com/submissions/detail/495720930/
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		print(test.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		print(test.combinationSum(new int[] { 2, 3, 5 }, 8));
		print(test.combinationSum(new int[] { 2 }, 1));
		print(test.combinationSum(new int[] { 1 }, 1));
		print(test.combinationSum(new int[] { 1 }, 2));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		this.getCombination(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	private void getCombination(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
		} else if (target > 0) {
			for (int idx = start; idx < candidates.length; idx++) {
				list.add(candidates[idx]);
				this.getCombination(result, list, candidates, target - candidates[idx], idx);
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
