package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {

	// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/submissions/1136206658/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMakeArrayEmpty test = new MinimumNumberOfOperationsToMakeArrayEmpty();
		System.out.println(test.minOperations(new int[] { 2, 3, 3, 2, 2, 4, 2, 3, 4 }));
		System.out.println(test.minOperations(new int[] { 2, 1, 2, 2, 3, 3 }));
	}

	public int minOperations(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value == 1) {
				return -1;
			}
			result += value / 3;
			if (value % 3 != 0) {
				result++;
			}
		}
		return result;
	}

}
