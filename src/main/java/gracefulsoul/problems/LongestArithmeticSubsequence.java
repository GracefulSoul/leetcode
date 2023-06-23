package gracefulsoul.problems;

public class LongestArithmeticSubsequence {

	// https://leetcode.com/problems/longest-arithmetic-subsequence/submissions/977758689/
	public static void main(String[] args) {
		LongestArithmeticSubsequence test = new LongestArithmeticSubsequence();
		System.out.println(test.longestArithSeqLength(new int[] { 3, 6, 9, 12 }));
		System.out.println(test.longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
		System.out.println(test.longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
	}

	public int longestArithSeqLength(int[] nums) {
		int result = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		for (int i = 0; i <= max - min; i++) {
			if (i * result > max - min) {
				break;
			}
			int[] first = new int[501];
			int[] second = new int[501];
			for (int num : nums) {
				first[num] = (num + i <= 500) ? (first[num + i] + 1) : 1;
				second[num] = (num - i >= 0) ? (second[num - i] + 1) : 1;
				result = Math.max(result, Math.max(first[num], second[num]));
			}
		}
		return result;
	}

}
