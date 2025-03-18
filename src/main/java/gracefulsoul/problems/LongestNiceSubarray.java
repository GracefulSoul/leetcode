package gracefulsoul.problems;

public class LongestNiceSubarray {

	// https://leetcode.com/problems/longest-nice-subarray/submissions/1577739340/
	public static void main(String[] args) {
		LongestNiceSubarray test = new LongestNiceSubarray();
		System.out.println(test.longestNiceSubarray(new int[] { 1, 3, 8, 48, 10 }));
		System.out.println(test.longestNiceSubarray(new int[] { 3, 1, 5, 11, 13 }));
	}

	public int longestNiceSubarray(int[] nums) {
		int result = 0;
		int i = 0;
		int and = 0;
		for (int j = 0; j < nums.length; j++) {
			while ((and & nums[j]) > 0) {
				and ^= nums[i++];
			}
			and |= nums[j];
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

}
