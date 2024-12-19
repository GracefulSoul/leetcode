package gracefulsoul.problems;

public class LongestArithmeticSubsequenceOfGivenDifference {

	// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/submissions/1482812273/
	public static void main(String[] args) {
		LongestArithmeticSubsequenceOfGivenDifference test = new LongestArithmeticSubsequenceOfGivenDifference();
		System.out.println(test.longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
		System.out.println(test.longestSubsequence(new int[] { 1, 3, 5, 7 }, 1));
		System.out.println(test.longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
	}

	public int longestSubsequence(int[] arr, int difference) {
		int[] map = new int[40001];
		int result = 1;
		for (int num : arr) {
			int index = 20000 + num;
			map[index] = map[index - difference] + 1;
			result = Math.max(result, map[index]);
		}
		return result;
	}

}
