package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class ClosestPrimeNumbersInRange {

	// https://leetcode.com/problems/closest-prime-numbers-in-range/submissions/1565858608/
	public static void main(String[] args) {
		ClosestPrimeNumbersInRange test = new ClosestPrimeNumbersInRange();
		PrintUtil.print(test.closestPrimes(10, 19));
		PrintUtil.print(test.closestPrimes(4, 6));
	}

	public int[] closestPrimes(int left, int right) {
		List<Integer> primes = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (2 < i && i % 2 == 0) {
				continue;
			}
			if (this.isPrime(i)) {
				if (!primes.isEmpty() && i <= primes.get(primes.size() - 1) + 2) {
					return new int[] { primes.get(primes.size() - 1), i };
				}
				primes.add(i);
			}
		}
		if (primes.size() < 2) {
			return new int[] { -1, -1 };
		}
		int[] result = new int[2];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < primes.size(); i++) {
			int diff = primes.get(i) - primes.get(i - 1);
			if (diff < min) {
				min = diff;
				result[0] = primes.get(i - 1);
				result[1] = primes.get(i);
			}
		}
		return result;
	}

	private boolean isPrime(int number) {
		if (number == 1) {
			return false;
		} else {
			for (int i = 2; i <= (int) Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
