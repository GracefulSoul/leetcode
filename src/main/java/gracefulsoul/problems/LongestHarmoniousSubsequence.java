package gracefulsoul.problems;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {

	// https://leetcode.com/submissions/detail/756191194/
	public static void main(String[] args) {
		LongestHarmoniousSubsequence test = new LongestHarmoniousSubsequence();
		System.out.println(test.findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
		System.out.println(test.findLHS(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.findLHS(new int[] { 1, 1, 1, 1 }));
	}

	public int findLHS(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			if (idx == 0 || nums[idx] != nums[idx - 1]) {
				int next = idx + 1;
				int curr = nums[idx];
				int length = 1;
				while (next < nums.length && nums[next] - curr <= 1) {
					length++;
					next++;
				}
				if (nums[next - 1] - curr == 1 && length > max) {
					max = length;
				}
			}
		}
		return max;
	}

}
