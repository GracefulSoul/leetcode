package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {

	// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/submissions/1216247472/
	public static void main(String[] args) {
		LengthOfLongestSubarrayWithAtMostKFrequency test = new LengthOfLongestSubarrayWithAtMostKFrequency();
		System.out.println(test.maxSubarrayLength(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }, 2));
		System.out.println(test.maxSubarrayLength(new int[] { 1, 2, 1, 2, 1, 2, 1, 2 }, 1));
		System.out.println(test.maxSubarrayLength(new int[] { 5, 5, 5, 5, 5, 5, 5 }, 4));
	}

	public int maxSubarrayLength(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<>();
		int result = 0;
		for (int i = 0, j = 0; j < nums.length; j++) {
			count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
			while (count.get(nums[j]) > k) {
				count.put(nums[i], count.get(nums[i++]) - 1);
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

}
