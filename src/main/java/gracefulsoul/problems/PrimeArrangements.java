package gracefulsoul.problems;

import java.util.Arrays;

public class PrimeArrangements {

	// https://leetcode.com/problems/prime-arrangements/submissions/1368795070/
	public static void main(String[] args) {
		PrimeArrangements test = new PrimeArrangements();
		System.out.println(test.numPrimeArrangements(5));
		System.out.println(test.numPrimeArrangements(100));
	}

	public int numPrimeArrangements(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = i * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		int count = 0;
		for (boolean prime : primes) {
			if (prime) {
				count++;
			}
		}
		long result = 1;
		for (int i = 2; i <= count; i++) {
			result = (result * i) % 1000000007;
		}
		for (int i = 2; i <= n - count; i++) {
			result = (result * i) % 1000000007;
		}
		return (int) result;
	}

}
