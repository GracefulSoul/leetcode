package gracefulsoul.problems;

public class CountCommasInRangeII {

	// https://leetcode.com/problems/count-commas-in-range-ii/submissions/2136460847/
	public static void main(String[] args) {
		CountCommasInRangeII test = new CountCommasInRangeII();
		System.out.println(test.countCommas(1002));
		System.out.println(test.countCommas(998));
	}

	public long countCommas(long n) {
		long result = 0;
		for (long i = 1000; i <= n; i *= 1000) {
			result += n - i + 1;
		}
		return result;
	}

}
