package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialTriplets {

	// https://leetcode.com/problems/count-special-triplets/submissions/1851008674/
	public static void main(String[] args) {
		CountSpecialTriplets test = new CountSpecialTriplets();
		System.out.println(test.specialTriplets(new int[] { 6, 3, 6 }));
		System.out.println(test.specialTriplets(new int[] { 0, 1, 0, 0 }));
		System.out.println(test.specialTriplets(new int[] { 8, 4, 2, 8, 4 }));
	}

	public int specialTriplets(int[] nums) {
		int mod = 1000000007;
		int result = 0;
		Map<Integer, Integer> left = new HashMap<>();
		Map<Integer, Integer> right = new HashMap<>();
		for (int num : nums) {
			right.put(num, right.getOrDefault(num, 0) + 1);
		}
		for (int num : nums) {
			right.put(num, right.get(num) - 1);
			int key = num * 2;
			result = (int) ((result + (1L * left.getOrDefault(key, 0) * right.getOrDefault(key, 0))) % mod);
			left.put(num, left.getOrDefault(num, 0) + 1);
		}
		return result;
	}

}
