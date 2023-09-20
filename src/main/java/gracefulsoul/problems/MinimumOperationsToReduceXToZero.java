package gracefulsoul.problems;

public class MinimumOperationsToReduceXToZero {

	// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/submissions/1054481507/
	public static void main(String[] args) {
		MinimumOperationsToReduceXToZero test = new MinimumOperationsToReduceXToZero();
		System.out.println(test.minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
		System.out.println(test.minOperations(new int[] { 5, 6, 7, 8, 9 }, 4));
		System.out.println(test.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
	}

	public int minOperations(int[] nums, int x) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int max = -1;
		int curr = 0;
		for (int left = 0, right = 0; right < nums.length; right++) {
			curr += nums[right];
			while (left <= right && curr > sum - x) {
				curr -= nums[left++];
			}
			if (curr == sum - x) {
				max = Math.max(max, right - left + 1);
			}
		}
		return max == -1 ? -1 : nums.length - max;
	}

}
