package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementQueries {

	// https://leetcode.com/problems/closest-equal-element-queries/submissions/1979935606/
	public static void main(String[] args) {
		ClosestEqualElementQueries test = new ClosestEqualElementQueries();
		System.out.println(test.solveQueries(new int[] { 1, 3, 1, 4, 1, 3, 2 }, new int[] { 0, 3, 5 }));
		System.out.println(test.solveQueries(new int[] { 1, 2, 3, 4 }, new int[] { 0, 1, 2, 3 }));
	}

	public List<Integer> solveQueries(int[] nums, int[] queries) {
		int length = nums.length;
		Map<Integer, Integer> seen = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < length * 2; i++) {
			if (i < length) {
				list.add(length + 1);
			}
			if (seen.containsKey(nums[i % length])) {
				int curr = i % length;
				int prev = seen.get(nums[curr]) % length;
				int reverse = i - seen.get(nums[curr]);
				list.set(curr, Math.min(list.get(curr), reverse));
				list.set(prev, Math.min(list.get(prev), reverse));
			}
			seen.put(nums[i % length], i);
		}
		List<Integer> result = new ArrayList<>();
		for (int query : queries) {
			result.add((list.get(query) >= length) ? -1 : list.get(query));
		}
		return result;
	}

}
