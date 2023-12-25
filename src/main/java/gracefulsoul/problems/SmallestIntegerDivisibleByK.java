package gracefulsoul.problems;

public class SmallestIntegerDivisibleByK {

	// https://leetcode.com/problems/smallest-integer-divisible-by-k/submissions/1127868157/
	public static void main(String[] args) {
		SmallestIntegerDivisibleByK test = new SmallestIntegerDivisibleByK();
		System.err.println(test.smallestRepunitDivByK(1));
		System.err.println(test.smallestRepunitDivByK(2));
		System.err.println(test.smallestRepunitDivByK(3));
	}

	public int smallestRepunitDivByK(int k) {
		if (k % 2 == 0 || k % 5 == 0) {
			return -1;
		}
		int result = 0;
		for (int i = 1; i <= k; i++) {
			result = ((result * 10) + 1) % k;
			if (result == 0) {
				return i;
			}
		}
		return -1;
	}

}
