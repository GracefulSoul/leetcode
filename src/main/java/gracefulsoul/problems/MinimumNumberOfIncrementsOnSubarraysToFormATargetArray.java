package gracefulsoul.problems;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {

	// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/submissions/1815776874/
	public static void main(String[] args) {
		MinimumNumberOfIncrementsOnSubarraysToFormATargetArray test = new MinimumNumberOfIncrementsOnSubarraysToFormATargetArray();
		System.out.println(test.minNumberOperations(new int[] { 1, 2, 3, 2, 1 }));
		System.out.println(test.minNumberOperations(new int[] { 3, 1, 1, 2 }));
		System.out.println(test.minNumberOperations(new int[] { 3, 1, 5, 4, 2 }));
	}

	public int minNumberOperations(int[] target) {
		int result = target[0];
		for (int i = 1; i < target.length; i++) {
			result += Math.max(0, target[i] - target[i - 1]);
		}
		return result;
	}

}
