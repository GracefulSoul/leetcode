package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.List;

public class MinimumPairRemovalToSortArrayI {

	// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/submissions/1893247675/
	public static void main(String[] args) {
		MinimumPairRemovalToSortArrayI test = new MinimumPairRemovalToSortArrayI();
		System.out.println(test.minimumPairRemoval(new int[] { 5, 2, 3, 1 }));
		System.out.println(test.minimumPairRemoval(new int[] { 1, 2, 2 }));
	}

	public int minimumPairRemoval(int[] nums) {
		List<Integer> list = new LinkedList<>();
		for (int num : nums) {
			list.add(num);
		}
		int ops = 0;
		while (!isSorted(list)) {
			int sum = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				int temp = list.get(i) + list.get(i + 1);
				if (temp < sum) {
					sum = temp;
					idx = i;
				}
			}
			list.set(idx, sum);
			list.remove(idx + 1);
			ops++;
		}
		return ops;
	}

	private boolean isSorted(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

}
