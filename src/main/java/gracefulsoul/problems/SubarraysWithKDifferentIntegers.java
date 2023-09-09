package gracefulsoul.problems;

public class SubarraysWithKDifferentIntegers {

	// https://leetcode.com/problems/subarrays-with-k-different-integers/submissions/1044465023/
	public static void main(String[] args) {
		SubarraysWithKDifferentIntegers test = new SubarraysWithKDifferentIntegers();
		System.out.println(test.subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
		System.out.println(test.subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3));
	}

	public int subarraysWithKDistinct(int[] nums, int k) {
		int result = 0;
		int prefix = 1;
		int[] count = new int[nums.length + 1];
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (count[nums[i]]++ == 0) {
				k--;
			}
			while (k < 0) {
				if (--count[nums[j++]] == 0) {
					k++;
				}
				prefix = 1;
			}
			if (k == 0) {
				while (count[nums[j]] > 1) {
					count[nums[j++]]--;
					prefix++;
				}
				result += prefix;
			}
		}
		return result;
	}

}
