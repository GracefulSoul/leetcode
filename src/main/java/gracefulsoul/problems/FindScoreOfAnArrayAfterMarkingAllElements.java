package gracefulsoul.problems;

import java.util.Arrays;

public class FindScoreOfAnArrayAfterMarkingAllElements {

	// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/submissions/1477724240/
	public static void main(String[] args) {
		FindScoreOfAnArrayAfterMarkingAllElements test = new FindScoreOfAnArrayAfterMarkingAllElements();
		System.out.println(test.findScore(new int[] { 2, 1, 3, 4, 5, 2 }));
		System.out.println(test.findScore(new int[] { 2, 3, 5, 1, 3, 2 }));
	}

	public long findScore(int[] nums) {
		int length = nums.length;
		Integer[] dp = new Integer[length];
		for (int i = 0; i < length; i++) {
			dp[i] = i;
		}
		Arrays.sort(dp, (a, b) -> nums[a] - nums[b]);
		long result = 0;
		boolean[] marked = new boolean[length + 2];
		for (int i : dp) {
			if (!marked[i + 1]) {
				marked[i] = marked[i + 2] = true;
				result += nums[i];
			}
		}
		return result;
	}

}
