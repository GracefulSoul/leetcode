package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {

	// https://leetcode.com/problems/count-nice-pairs-in-an-array/submissions/1103351421/
	public static void main(String[] args) {
		CountNicePairsInAnArray test = new CountNicePairsInAnArray();
		System.out.println(test.countNicePairs(new int[] { 42, 11, 1, 97 }));
		System.out.println(test.countNicePairs(new int[] { 13, 10, 35, 24, 76 }));
	}

	public int countNicePairs(int[] nums) {
		int result = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			int reverse = 0;
			for (int i = num; i > 0; i /= 10) {
				reverse = (reverse * 10) + (i % 10);
			}
			int value = count.getOrDefault(num - reverse, 0);
			count.put(num - reverse, value + 1);
			result = (result + value) % 1000000007;
		}
		return result;
	}

}
