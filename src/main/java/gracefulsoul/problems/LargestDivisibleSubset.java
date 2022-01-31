package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	// https://leetcode.com/submissions/detail/631307010/
	public static void main(String[] args) {
		LargestDivisibleSubset test = new LargestDivisibleSubset();
		System.out.println(test.largestDivisibleSubset(new int[] { 1, 2, 3 }));
		System.out.println(test.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int length = nums.length;
		int[][] dp = new int[length][2];
		Arrays.sort(nums);
		int max = 0;
		int index = -1;
		for (int i = 0; i < length; i++) {
			dp[i][0] = 1;
			dp[i][1] = -1;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j;
				}
			}
			if (dp[i][0] > max) {
				max = dp[i][0];
				index = i;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		while (index != -1) {
			result.add(nums[index]);
			index = dp[index][1];
		}
		return result;
	}

}
