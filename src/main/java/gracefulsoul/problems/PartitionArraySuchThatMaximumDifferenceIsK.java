package gracefulsoul.problems;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

	// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/submissions/1669446465/
	public static void main(String[] args) {
		PartitionArraySuchThatMaximumDifferenceIsK test = new PartitionArraySuchThatMaximumDifferenceIsK();
		System.out.println(test.partitionArray(new int[] { 3, 6, 1, 2, 5 }, 2));
		System.out.println(test.partitionArray(new int[] { 1, 2, 3 }, 1));
		System.out.println(test.partitionArray(new int[] { 2, 2, 4, 5 }, 0));
	}

	public int partitionArray(int[] nums, int k) {
		Arrays.sort(nums);
		int result = 1;
		for (int i = 1, j = 0; i < nums.length; i++) {
			if (nums[i] - nums[j] > k) {
				result++;
				j = i;
			}
		}
		return result;
	}

}
