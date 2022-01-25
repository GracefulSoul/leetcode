package gracefulsoul.problems;

import java.util.Arrays;

public class RussianDollEnvelopes {

	// https://leetcode.com/submissions/detail/627203714/
	public static void main(String[] args) {
		RussianDollEnvelopes test = new RussianDollEnvelopes();
		System.out.println(test.maxEnvelopes(new int[][] {
			new int[] { 5, 4 },
			new int[] { 6, 4 },
			new int[] { 6, 7 },
			new int[] { 2, 3 }
		}));
		System.out.println(test.maxEnvelopes(new int[][] {
			new int[] { 1, 1 },
			new int[] { 1, 1 },
			new int[] { 1, 1 }
		}));
	}

	public int maxEnvelopes(int[][] envelopes) {
		int dp[] = new int[envelopes.length];
		int count = 0;
		Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
		for (int[] envelope : envelopes) {
			int index = Arrays.binarySearch(dp, 0, count, envelope[1]);
			if (index < 0) {
				index = -(index + 1);
			}
			dp[index] = envelope[1];
			if (index == count) {
				count++;
			}
		}
		return count;
	}

}
