package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

	// https://leetcode.com/problems/minimum-absolute-difference/submissions/1897423404/
	public static void main(String[] args) {
		MinimumAbsoluteDifference test = new MinimumAbsoluteDifference();
		System.out.println(test.minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
		System.out.println(test.minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 }));
		System.out.println(test.minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));
	}

	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i] - arr[i - 1]);
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (min == diff) {
				result.add(Arrays.asList(arr[i - 1], arr[i]));
			}
		}
		return result;
	}

}
