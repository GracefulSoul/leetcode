package gracefulsoul.problems;

import java.util.Arrays;

public class LongestConsecutiveSequence {

	// https://leetcode.com/submissions/detail/539682680/
	public static void main(String[] args) {
		LongestConsecutiveSequence test = new LongestConsecutiveSequence();
		System.out.println(test.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(test.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int curr = nums[0];
		int sum = 1;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				continue;
			} else if (nums[i] == curr + 1) {
				curr++;
				sum++;
				count = Math.max(count, sum);
			} else {
				curr = nums[i];
				sum = 1;
			}
		}
		return count;
	}

}
