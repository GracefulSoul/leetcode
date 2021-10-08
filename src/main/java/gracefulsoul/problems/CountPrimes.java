package gracefulsoul.problems;

public class CountPrimes {

	// https://leetcode.com/submissions/detail/567589481/
	public static void main(String[] args) {
		CountPrimes test = new CountPrimes();
		System.out.println(test.countPrimes(10));
		System.out.println(test.countPrimes(0));
		System.out.println(test.countPrimes(1));
	}

	public int countPrimes(int n) {
		if (n < 3) {
			return 0;
		}
		int result = n / 2;
		boolean[] notPrime = new boolean[n];
		for (int i = 3; i * i < n; i += 2) {
			if (notPrime[i]) {
				continue;
			}
			for (int j = i * i; j < n; j += 2 * i) {
				if (!notPrime[j]) {
					result--;
					notPrime[j] = true;
				}
			}
		}
		return result;
	}

}
