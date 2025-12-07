package gracefulsoul.problems;

public class CountOddNumbersInAnIntervalRange {

	// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/submissions/1849075283/
	public static void main(String[] args) {
		CountOddNumbersInAnIntervalRange test = new CountOddNumbersInAnIntervalRange();
		System.out.println(test.countOdds(3, 7));
		System.out.println(test.countOdds(8, 10));
		System.out.println(test.countOdds(14, 17));
	}

	public int countOdds(int low, int high) {
		return (high + 1) / 2 - low / 2;
	}

}
