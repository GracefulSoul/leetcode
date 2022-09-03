package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

	// https://leetcode.com/submissions/detail/790017249/
	public static void main(String[] args) {
		MaximumLengthOfPairChain test = new MaximumLengthOfPairChain();
		System.out.println(test.findLongestChain(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 }
		}));
		System.out.println(test.findLongestChain(new int[][] {
			{ 1, 2 },
			{ 7, 8 },
			{ 4, 5 }
		}));
	}

	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int pre = pairs[0][1];
		int count = 1;
		for (int idx = 1; idx < pairs.length; idx++) {
			if (pairs[idx][0] > pre) {
				pre = pairs[idx][1];
				count++;
			} else {
				pre = Math.min(pre, pairs[idx][1]);
			}
		}
		return count;
	}

}
