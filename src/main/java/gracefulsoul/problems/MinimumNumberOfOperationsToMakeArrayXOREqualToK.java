package gracefulsoul.problems;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

	// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/submissions/1244828555/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMakeArrayXOREqualToK test = new MinimumNumberOfOperationsToMakeArrayXOREqualToK();
		System.out.println(test.minOperations(new int[] { 2, 1, 3, 4 }, 1));
		System.out.println(test.minOperations(new int[] { 2, 0, 2, 0 }, 0));
	}

	public int minOperations(int[] nums, int k) {
		for (int num : nums) {
			k ^= num;
		}
		return Integer.bitCount(k);
	}

}
