package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

	// https://leetcode.com/problems/make-sum-divisible-by-p/submissions/1409943523/
	public static void main(String[] args) {
		MakeSumDivisibleByP test = new MakeSumDivisibleByP();
		System.out.println(test.minSubarray(new int[] { 3, 1, 4, 2 }, 6));
		System.out.println(test.minSubarray(new int[] { 6, 3, 5, 2 }, 9));
		System.out.println(test.minSubarray(new int[] { 1, 2, 3 }, 3));
	}

	public int minSubarray(int[] nums, int p) {
		int remainder = 0;
		for (int num : nums) {
			remainder = (remainder + num) % p;
		}
		if (remainder == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int length = nums.length;
		int min = length;
		int curr = 0;
		for (int i = 0; i < length; i++) {
			curr = (curr + nums[i]) % p;
			map.put(curr, i);
			min = Math.min(min, i - map.getOrDefault((curr - remainder + p) % p, -length));
		}
		return min < length ? min : -1;
	}

}
