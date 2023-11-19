package gracefulsoul.problems;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {

	// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/submissions/1101865323/
	public static void main(String[] args) {
		ReductionOperationsToMakeTheArrayElementsEqual test = new ReductionOperationsToMakeTheArrayElementsEqual();
		System.out.println(test.reductionOperations(new int[] { 5, 1, 3 }));
		System.out.println(test.reductionOperations(new int[] { 1, 1, 1 }));
		System.out.println(test.reductionOperations(new int[] { 1, 1, 2, 2, 3 }));
	}

	public int reductionOperations(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		int length = nums.length;
		for (int i = length - 1; i > 0; i--) {
			if (nums[i - 1] != nums[i]) {
				result += length - i;
			}
		}
		return result;
	}

}
