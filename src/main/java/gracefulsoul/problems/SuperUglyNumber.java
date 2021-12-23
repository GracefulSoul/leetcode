package gracefulsoul.problems;

import java.util.Arrays;

public class SuperUglyNumber {

	// https://leetcode.com/submissions/detail/605803844/
	public static void main(String[] args) {
		SuperUglyNumber test = new SuperUglyNumber();
		System.out.println(test.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
		System.out.println(test.nthSuperUglyNumber(1, new int[] { 2, 3, 5 }));
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] nums = new int[n];
		int pre = 1;
		int min = 1;
		int length = primes.length;
		int[] idx = new int[length];
		int[] prePrimes = new int[length];
		Arrays.fill(prePrimes, 1);
		for (int i = 0; i < n; i++) {
			nums[i] = min;
			min = Integer.MAX_VALUE;
			for (int j = 0; j < length; j++) {
				if (prePrimes[j] == pre) {
					prePrimes[j] = primes[j] * nums[idx[j]];
					idx[j]++;
				}
				min = Math.min(prePrimes[j], min);
			}
			pre = min;
		}
		return nums[n - 1];
	}

}
