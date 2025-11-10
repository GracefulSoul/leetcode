package gracefulsoul.problems;

public class MinimumOperationsToConvertAllElementsToZero {

	// https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/submissions/1825830591/
	public static void main(String[] args) {
		MinimumOperationsToConvertAllElementsToZero test = new MinimumOperationsToConvertAllElementsToZero();
		System.out.println(test.minOperations(new int[] { 0, 2 }));
		System.out.println(test.minOperations(new int[] { 3, 1, 2, 1 }));
		System.out.println(test.minOperations(new int[] { 1, 2, 1, 2, 1, 2 }));
	}

	public int minOperations(int[] nums) {
		int length = nums.length;
		int result = 0;
		boolean[] seen = new boolean[100001];
		int[] stack = new int[length];
		int size = 0;
		for (int num : nums) {
			if (num == 0) {
				while (size > 0) {
					seen[stack[--size]] = false;
				}
				continue;
			}
			while (size > 0 && stack[size - 1] > num) {
				seen[stack[--size]] = false;
			}
			if (!seen[num]) {
				result++;
				seen[num] = true;
			}
			stack[size++] = num;
		}
		return result;
	}

}
