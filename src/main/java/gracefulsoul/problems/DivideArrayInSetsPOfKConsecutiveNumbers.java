package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayInSetsPOfKConsecutiveNumbers {

	// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/submissions/1854905141/
	public static void main(String[] args) {
		DivideArrayInSetsPOfKConsecutiveNumbers test = new DivideArrayInSetsPOfKConsecutiveNumbers();
		System.out.println(test.isPossibleDivide(new int[] { 1, 2, 3, 3, 4, 4, 5, 6 }, 4));
		System.out.println(test.isPossibleDivide(new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 }, 3));
		System.out.println(test.isPossibleDivide(new int[] { 1, 2, 3, 4 }, 3));
	}

	public boolean isPossibleDivide(int[] nums, int k) {
		if (nums.length % k != 0) {
			return false;
		} else {
			Arrays.sort(nums);
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				map.merge(num, 1, Integer::sum);
			}
			for (int num : nums) {
				if (map.getOrDefault(num, 0) > 0) {
					for (int i = num; i < num + k; i++) {
						if (map.merge(i, -1, Integer::sum) < 0) {
							return false;
						}
					}
				}
			}
			return true;
		}
	}

}
