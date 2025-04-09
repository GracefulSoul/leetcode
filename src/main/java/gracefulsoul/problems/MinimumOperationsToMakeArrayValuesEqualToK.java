package gracefulsoul.problems;

public class MinimumOperationsToMakeArrayValuesEqualToK {

	// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/submissions/1601517781/
	public static void main(String[] args) {
		MinimumOperationsToMakeArrayValuesEqualToK test = new MinimumOperationsToMakeArrayValuesEqualToK();
		System.out.println(test.minOperations(new int[] { 5, 2, 5, 4, 5 }, 2));
		System.out.println(test.minOperations(new int[] { 2, 1, 2 }, 2));
		System.out.println(test.minOperations(new int[] { 9, 7, 5, 3 }, 1));
	}

	public int minOperations(int[] nums, int k) {
		boolean[] seen = new boolean[101];
		for (int num : nums) {
			seen[num] = true;
		}
		int count = 0;
		for (int i = 1; i < 101; i++) {
			if (seen[i]) {
				if (i < k) {
					return -1;
				} else if (i > k) {
					count++;
				}
			}
		}
		return count;
	}

}
