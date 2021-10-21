package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	// https://leetcode.com/submissions/detail/574620201/
	public static void main(String[] args) {
		CombinationSumIII test = new CombinationSumIII();
		System.out.println(test.combinationSum3(3, 7));
		System.out.println(test.combinationSum3(3, 9));
		System.out.println(test.combinationSum3(4, 1));
		System.out.println(test.combinationSum3(3, 2));
		System.out.println(test.combinationSum3(9, 45));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		this.getCombination(result, new ArrayList<>(), k, n, 1);
		return result;
	}

	private void getCombination(List<List<Integer>> result, List<Integer> list, int size, int target, int start) {
		if (list.size() > size || target < 0) {
			return;
		} else if (list.size() == size && target == 0) {
			result.add(new ArrayList<>(list));
		} else {
			for (int idx = start; idx < 10; idx++) {
				list.add(idx);
				this.getCombination(result, list, size, target - idx, idx + 1);
				list.remove(list.size() - 1);
			}
		}
	}

}
