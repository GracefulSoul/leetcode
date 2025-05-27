package gracefulsoul.problems;

public class DivisibleAndNonDivisibleSumsDifference {

	// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/submissions/1645883840/
	public static void main(String[] args) {
		DivisibleAndNonDivisibleSumsDifference test = new DivisibleAndNonDivisibleSumsDifference();
		System.out.println(test.differenceOfSums(10, 3));
		System.out.println(test.differenceOfSums(5, 6));
		System.out.println(test.differenceOfSums(5, 1));
	}

	public int differenceOfSums(int n, int m) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (i % m == 0) {
				result -= i;
			} else {
				result += i;
			}
		}
		return result;
	}

}
