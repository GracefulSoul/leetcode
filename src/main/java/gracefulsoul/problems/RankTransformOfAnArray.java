package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class RankTransformOfAnArray {

	// https://leetcode.com/problems/rank-transform-of-an-array/submissions/1409446788/
	public static void main(String[] args) {
		RankTransformOfAnArray test = new RankTransformOfAnArray();
		PrintUtil.print(test.arrayRankTransform(new int[] { 40, 10, 20, 30 }));
		PrintUtil.print(test.arrayRankTransform(new int[] { 100, 100, 100 }));
		PrintUtil.print(test.arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 }));
	}

	public int[] arrayRankTransform(int[] arr) {
		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 1;
		for (int val : sortedArr) {
			if (!map.containsKey(val)) {
				map.put(val, rank++);
			}
		}
		int length = arr.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = map.get(arr[i]);
		}
		return result;
	}

}
