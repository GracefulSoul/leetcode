package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays {

	// https://leetcode.com/problems/count-the-number-of-good-subarrays/submissions/1608465104/
	public static void main(String[] args) {
		CountTheNumberOfGoodSubarrays test = new CountTheNumberOfGoodSubarrays();
		System.out.println(test.countGood(new int[] { 1, 1, 1, 1, 1 }, 10));
		System.out.println(test.countGood(new int[] { 3, 1, 4, 3, 2, 2, 4 }, 2));
	}

	public long countGood(int[] nums, int k) {
		long result = 0L;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < nums.length; j++) {
			int num = map.getOrDefault(nums[j], 0);
			k -= num;
			map.put(nums[j], num + 1);
			while (k <= 0) {
				map.put(nums[i], map.get(nums[i]) - 1);
				k += map.get(nums[i]);
			}
			result += i;
		}
		return result;
	}

}
