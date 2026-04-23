package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class SumOfDistances {

	// https://leetcode.com/problems/sum-of-distances/submissions/1986048704/
	public static void main(String[] args) {
		SumOfDistances test = new SumOfDistances();
		PrintUtil.print(test.distance(new int[] { 1, 3, 1, 1, 2 }));
		PrintUtil.print(test.distance(new int[] { 0, 5, 3 }));
	}

	public long[] distance(int[] nums) {
		int length = nums.length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}
		long[] result = new long[length];
		for (List<Integer> positions : map.values()) {
			long total = 0;
			for (int num : positions) {
				total += num;
			}
			long leftSum = 0;
			int j = positions.size();
			for (int i = 0; i < j; i++) {
				int index = positions.get(i);
				long rightSum = total - leftSum - index;
				long left = ((long) index * i) - leftSum;
				long right = rightSum - ((long) index * (j - i - 1));
				result[index] = left + right;
				leftSum += index;
			}
		}
		return result;
	}

}
