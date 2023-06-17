package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayStrictlyIncreasing {

	// https://leetcode.com/problems/make-array-strictly-increasing/submissions/973016173/
	public static void main(String[] args) {
		MakeArrayStrictlyIncreasing test = new MakeArrayStrictlyIncreasing();
		System.out.println(test.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 }, new int[] { 1, 3, 2, 4 }));
		System.out.println(test.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 }, new int[] { 4, 3, 1 }));
		System.out.println(test.makeArrayIncreasing(new int[] { 1, 5, 3, 6, 7 }, new int[] { 1, 6, 3, 3 }));
	}

	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
		Arrays.sort(arr2);
		Map<Integer, Integer> dp = new HashMap<>();
		dp.put(-1, 0);
		for (int num : arr1) {
			Map<Integer, Integer> temp = new HashMap<>();
			for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
				int val = entry.getValue();
				if (num > entry.getKey()) {
					temp.put(num, Math.min(temp.getOrDefault(num, Integer.MAX_VALUE), val));
				}
				int index = Arrays.binarySearch(arr2, entry.getKey() + 1);
				if (index < 0) {
					index = -index - 1;
				}
				if (index < arr2.length) {
					temp.put(arr2[index], Math.min(val + 1, temp.getOrDefault(arr2[index], Integer.MAX_VALUE)));
				}
			}
			dp = temp;
		}
		return dp.isEmpty() ? -1 : Collections.min(dp.values());
	}

}
