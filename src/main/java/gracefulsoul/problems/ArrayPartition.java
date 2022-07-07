package gracefulsoul.problems;

import java.util.Arrays;

public class ArrayPartition {

	// https://leetcode.com/submissions/detail/740992121/
	public static void main(String[] args) {
		ArrayPartition test = new ArrayPartition();
		System.out.println(test.arrayPairSum(new int[] { 1, 4, 3, 2 }));
		System.out.println(test.arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));
	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		for (int idx = 0; idx < nums.length; idx += 2) {
			max += nums[idx];
		}
		return max;
	}

}
