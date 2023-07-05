package gracefulsoul.problems;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

	// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/986842780/
	public static void main(String[] args) {
		LongestSubarrayOfOnesAfterDeletingOneElement test = new LongestSubarrayOfOnesAfterDeletingOneElement();
		System.out.println(test.longestSubarray(new int[] { 1, 1, 0, 1 }));
		System.out.println(test.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
		System.out.println(test.longestSubarray(new int[] { 1, 1, 1 }));
	}

	public int longestSubarray(int[] nums) {
		int i = 0;
		int j = 0;
		for (int k = 1; j < nums.length; j++) {
			if (nums[j] == 0) {
				k--;
			}
			if (k < 0 && nums[i++] == 0) {
				k++;
			}
		}
		return j - i - 1;
	}

}
