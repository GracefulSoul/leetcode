package gracefulsoul.problems;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/1108826334/
	public static void main(String[] args) {
		PairsOfSongsWithTotalDurationsDivisibleBy60 test = new PairsOfSongsWithTotalDurationsDivisibleBy60();
		System.out.println(test.numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));
		System.out.println(test.numPairsDivisibleBy60(new int[] { 60, 60, 60 }));
	}

	public int numPairsDivisibleBy60(int[] time) {
		long[] count = new long[60];
		for (int t : time) {
			count[t % 60]++;
		}
		long result = 0;
		if (count[0] > 0) {
			result += count[0] * (count[0] - 1) / 2;
		}
		if (count[30] > 0) {
			result += count[30] * (count[30] - 1) / 2;
		}
		for (int i = 1; i < 30; i++) {
			result += count[i] * count[60 - i];
		}
		return (int) result;
	}

}
