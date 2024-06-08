package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	// https://leetcode.com/submissions/detail/1281632196/
	public static void main(String[] args) {
		ContinuousSubarraySum test = new ContinuousSubarraySum();
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
		System.out.println(test.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 13));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum %= k;
			}
			Integer prev = map.get(sum);
			if (prev != null) {
				if (i - prev > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}

}
