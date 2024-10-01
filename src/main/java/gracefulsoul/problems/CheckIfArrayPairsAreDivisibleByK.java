package gracefulsoul.problems;

public class CheckIfArrayPairsAreDivisibleByK {

	// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/submissions/1407885522/
	public static void main(String[] args) {
		CheckIfArrayPairsAreDivisibleByK test = new CheckIfArrayPairsAreDivisibleByK();
		System.out.println(test.canArrange(new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }, 5));
		System.out.println(test.canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
		System.out.println(test.canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 10));
	}

	public boolean canArrange(int[] arr, int k) {
		int[] counts = new int[k];
		for (int num : arr) {
			counts[((num % k) + k) % k]++;
		}
		if (counts[0] % 2 != 0) {
			return false;
		}
		for (int i = 1; i <= k / 2; i++) {
			if (counts[i] != counts[k - i]) {
				return false;
			}
		}
		return true;
	}

}
