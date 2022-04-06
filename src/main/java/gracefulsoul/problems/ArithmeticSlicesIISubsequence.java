package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {

	// https://leetcode.com/submissions/detail/673997445/
	public static void main(String[] args) {
		ArithmeticSlicesIISubsequence test = new ArithmeticSlicesIISubsequence();
		System.out.println(test.numberOfArithmeticSlices(new int[] { 2, 4, 6, 8, 10 }));
//		System.out.println(test.numberOfArithmeticSlices(new int[] { 7, 7, 7, 7, 7 }));
	}

	public int numberOfArithmeticSlices(int[] nums) {
		int result = 0;
		int length = nums.length;
		int[][] dp = new int[length][length];
		Map<Long, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				List<Integer> list = map.get(nums[i] - (nums[j] - (long) nums[i]));
				if (list == null) {
					continue;
				}
				for (int num : list) {
					dp[i][j] += dp[num][i] + 1;
				}
				result += dp[i][j];
			}
			map.computeIfAbsent((long) nums[i], k -> new ArrayList<>()).add(i);
		}
		return result;
	}

}
