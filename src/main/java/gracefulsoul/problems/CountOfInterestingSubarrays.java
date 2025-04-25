package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfInterestingSubarrays {

	// https://leetcode.com/problems/count-of-interesting-subarrays/submissions/1617466371/
	public static void main(String[] args) {
		CountOfInterestingSubarrays test = new CountOfInterestingSubarrays();
		System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
		System.out.println(test.countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
	}

	public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		long result = 0;
		int sum = 0;
		for (int num : nums) {
			sum = (sum + (num % modulo == k ? 1 : 0)) % modulo;
			result += map.getOrDefault((sum - k + modulo) % modulo, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return result;
	}

}
