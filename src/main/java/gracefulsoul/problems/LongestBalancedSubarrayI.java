package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarrayI {

	// https://leetcode.com/problems/longest-balanced-subarray-i/submissions/1914528369/
	public static void main(String[] args) {
		LongestBalancedSubarrayI test = new LongestBalancedSubarrayI();
		System.out.println(test.longestBalanced(new int[] { 2, 5, 4, 3 }));
		System.out.println(test.longestBalanced(new int[] { 3, 2, 2, 5, 4 }));
		System.out.println(test.longestBalanced(new int[] { 1, 2, 3, 2 }));
	}

	public int longestBalanced(int[] nums) {
		int length = nums.length;
		int result = 0;
		for (int i = 0; i < length; i++) {
			Set<Integer> even = new HashSet<>();
			Set<Integer> odd = new HashSet<>();
			for (int j = i; j < length; j++) {
				if (nums[j] % 2 == 0) {
					even.add(nums[j]);
				} else {
					odd.add(nums[j]);
				}
				if (even.size() == odd.size()) {
					result = Math.max(result, j - i + 1);
				}
			}
		}
		return result;
	}

}
