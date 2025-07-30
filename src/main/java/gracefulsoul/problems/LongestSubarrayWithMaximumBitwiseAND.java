package gracefulsoul.problems;

public class LongestSubarrayWithMaximumBitwiseAND {

	// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/submissions/1717022012/
	public static void main(String[] args) {
		LongestSubarrayWithMaximumBitwiseAND test = new LongestSubarrayWithMaximumBitwiseAND();
		System.out.println(test.longestSubarray(new int[] { 1, 2, 3, 3, 2, 2 }));
		System.out.println(test.longestSubarray(new int[] { 1, 2, 3, 4 }));
	}

	public int longestSubarray(int[] nums) {
		int result = 1;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		int temp = 0;
		for (int num : nums) {
			if (num == max) {
				temp++;
			} else {
				result = Math.max(result, temp);
				temp = 0;
			}
		}
		return Math.max(result, temp);
	}

}
