package gracefulsoul.problems;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

	// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/submissions/1578917356/
	public static void main(String[] args) {
		MinimumOperationsToMakeBinaryArrayElementsEqualToOneI test = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
		System.out.println(test.minOperations(new int[] { 0, 1, 1, 1, 0, 0 }));
		System.out.println(test.minOperations(new int[] { 0, 1, 1, 1 }));
	}

	public int minOperations(int[] nums) {
		int length = nums.length;
		int count = 0;
		for (int i = 0; i <= length - 3; i++) {
			if (nums[i] == 0) {
				nums[i] ^= 1;
				nums[i + 1] ^= 1;
				nums[i + 2] ^= 1;
				count++;
			}
		}
		return nums[length - 1] == 0 || nums[length - 2] == 0 ? -1 : count;
	}

}
