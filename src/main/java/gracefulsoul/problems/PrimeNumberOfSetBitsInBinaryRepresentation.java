package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

	// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/submissions/858894488/
	public static void main(String[] args) {
		PrimeNumberOfSetBitsInBinaryRepresentation test = new PrimeNumberOfSetBitsInBinaryRepresentation();
		System.out.println(test.countPrimeSetBits(6, 10));
		System.out.println(test.countPrimeSetBits(10, 15));
	}

	public int countPrimeSetBits(int left, int right) {
		Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
		int count = 0;
		for (int idx = left; idx <= right; idx++) {
			int bits = 0;
			for (int n = idx; n > 0; n >>= 1) {
				bits += n & 1;
			}
			if (primes.contains(bits)) {
				count++;
			}
		}
		return count;
	}

}
