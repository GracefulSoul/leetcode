package gracefulsoul.problems;

public class LengthOfLongestFibonacciSubsequence {

	// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/submissions/914948793/
	public static void main(String[] args) {
		LengthOfLongestFibonacciSubsequence test = new LengthOfLongestFibonacciSubsequence();
		System.out.println(test.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
		System.out.println(test.lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 }));
	}

	public int lenLongestFibSubseq(int[] arr) {
		int length = arr.length;
		int[][] dp = new int[length][length];
		int result = 0;
		for (int i = 2; i < length; i++) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				int val = arr[left] + arr[right] - arr[i];
				if (val < 0) {
					left++;
				} else if (val > 0) {
					right--;
				} else {
					dp[right][i] = dp[left][right] + 1;
					result = Math.max(result, dp[right][i]);
					left++;
					right--;
				}
			}
		}
		return result == 0 ? 0 : result + 2;
	}

}
