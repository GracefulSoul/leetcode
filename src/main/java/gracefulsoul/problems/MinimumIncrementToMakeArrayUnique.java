package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

	// https://leetcode.com/problems/minimum-increment-to-make-array-unique/submissions/992570052/
	public static void main(String[] args) {
		MinimumIncrementToMakeArrayUnique test = new MinimumIncrementToMakeArrayUnique();
		System.out.println(test.minIncrementForUnique(new int[] { 1, 2, 2 }));
		System.out.println(test.minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
	}

	public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		int need = 0;
		for (int num : nums) {
			result += Math.max(need - num, 0);
			need = Math.max(num, need) + 1;
		}
		return result;
	}

}
