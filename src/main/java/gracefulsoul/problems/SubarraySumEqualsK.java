package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	// https://leetcode.com/submissions/detail/739951495/
	public static void main(String[] args) {
		SubarraySumEqualsK test = new SubarraySumEqualsK();
		System.out.println(test.subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(test.subarraySum(new int[] { 1, 2, 3 }, 3));
	}

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		for (int num : nums) {
			sum += num;
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

}
