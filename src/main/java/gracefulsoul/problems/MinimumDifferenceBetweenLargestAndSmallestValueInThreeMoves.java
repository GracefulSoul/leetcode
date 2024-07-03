package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

	// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/submissions/1308038488/
	public static void main(String[] args) {
		MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves test = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
		System.out.println(test.minDifference(new int[] { 5, 3, 2, 4 }));
		System.out.println(test.minDifference(new int[] { 1, 5, 0, 10, 14 }));
		System.out.println(test.minDifference(new int[] { 3, 100, 20 }));
	}

	public int minDifference(int[] nums) {
		int length = nums.length;
		if (length < 5) {
			return 0;
		} else {
			int result = Integer.MAX_VALUE;
			Arrays.sort(nums);
			for (int i = 0; i < 4; i++) {
				result = Math.min(result, nums[length - 4 + i] - nums[i]);
			}
			return result;
		}
	}

}
