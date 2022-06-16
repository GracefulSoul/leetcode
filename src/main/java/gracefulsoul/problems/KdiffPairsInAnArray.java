package gracefulsoul.problems;

import java.util.Arrays;

public class KdiffPairsInAnArray {

	// https://leetcode.com/submissions/detail/723572278/
	public static void main(String[] args) {
		KdiffPairsInAnArray test = new KdiffPairsInAnArray();
		System.out.println(test.findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(test.findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(test.findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));
	}

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int slow = 0;
		int fast = 1;
		int count = 0;
		while (slow < nums.length && fast < nums.length) {
			if (slow == fast || nums[fast] - nums[slow] < k) {
				fast++;
			} else if (nums[fast] - nums[slow] > k) {
				slow++;
			} else {
				slow++;
				fast++;
				count++;
				while (slow < nums.length && nums[slow] == nums[slow - 1]) {
					slow++;
				}
			}
		}
		return count;
	}

}
