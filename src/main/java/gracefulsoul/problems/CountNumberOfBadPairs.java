package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {

	// https://leetcode.com/problems/count-number-of-bad-pairs/submissions/1536377579/
	public static void main(String[] args) {
		CountNumberOfBadPairs test = new CountNumberOfBadPairs();
		System.out.println(test.countBadPairs(new int[] { 4, 1, 3, 3 }));
		System.out.println(test.countBadPairs(new int[] { 1, 2, 3, 4, 5 }));
	}

	public long countBadPairs(int[] nums) {
		long count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = i - nums[i];
			int prev = map.getOrDefault(diff, 0);
			count += i - prev;
			map.put(diff, prev + 1);
		}
		return count;
	}

}
