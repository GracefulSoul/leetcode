package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {

	// https://leetcode.com/problems/maximum-distance-in-arrays/submissions/1357393283/
	public static void main(String[] args) {
		MaximumDistanceInArrays test = new MaximumDistanceInArrays();
		System.out.println(test.maxDistance(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(4, 5),
			Arrays.asList(1, 2, 3)
		)));
		System.out.println(test.maxDistance(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(1)
		)));
	}

	public int maxDistance(List<List<Integer>> arrays) {
		int result = 0;
		List<Integer> list = arrays.get(0);
		int min = list.getFirst();
		int max = list.getLast();
		for (int i = 1; i < arrays.size(); i++) {
			list = arrays.get(i);
			int first = list.getFirst();
			int last = list.getLast();
			result = Math.max(result, Math.max(Math.abs(last - min), Math.abs(first - max)));
			min = Math.min(min, first);
			max = Math.max(max, last);
		}
		return result;
	}

}
