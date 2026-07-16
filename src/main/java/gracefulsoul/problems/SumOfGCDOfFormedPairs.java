package gracefulsoul.problems;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {

	// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/submissions/2069741141/
	public static void main(String[] args) {
		SumOfGCDOfFormedPairs test = new SumOfGCDOfFormedPairs();
		System.out.println(test.gcdSum(new int[] { 2, 6, 4 }));
		System.out.println(test.gcdSum(new int[] { 3, 6, 2, 8 }));
	}

	public long gcdSum(int[] nums) {
		int length = nums.length;
		int max = 0;
		for (int i = 0; i < length; i++) {
			max = Math.max(max, nums[i]);
			nums[i] = this.getGcd(nums[i], max);
		}
		Arrays.sort(nums);
		long result = 0;
		for (int i = 0, j = length - 1; i < j; i++, j--) {
			result += this.getGcd(nums[i], nums[j]);
		}
		return result;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
