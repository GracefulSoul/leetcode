package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumCostToConvertStringI {

	// https://leetcode.com/problems/minimum-cost-to-convert-string-i/submissions/1334595601/
	public static void main(String[] args) {
		MinimumCostToConvertStringI test = new MinimumCostToConvertStringI();
		System.out.println(test.minimumCost("abcd", "acbe", new char[] { 'a', 'b', 'c', 'c', 'e', 'd' }, new char[] { 'b', 'c', 'b', 'e', 'b', 'e' }, new int[] { 2, 5, 5, 1, 2, 20 }));
		System.out.println(test.minimumCost("aaaa", "bbbb", new char[] { 'a', 'c' }, new char[] { 'c', 'b' }, new int[] { 1, 2 }));
		System.out.println(test.minimumCost("abcd", "abce", new char[] { 'a' }, new char[] { 'e' }, new int[] { 10000 }));
	}

	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		long result = 0;
		long[][] costs = new long[26][26];
		for (long[] row : costs) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		for (int i = 0; i < original.length; i++) {
			int num1 = original[i] - 'a';
			int num2 = changed[i] - 'a';
			costs[num1][num2] = Math.min(costs[num1][num2], cost[i]);
		}
		for (int i = 0; i < 26; i++) {
			costs[i][i] = 0;
		}
		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
				}
			}
		}
		for (int i = 0; i < source.length(); i++) {
			int num1 = source.charAt(i) - 'a';
			int num2 = target.charAt(i) - 'a';
			if (num1 == num2) {
				continue;
			}
			if (costs[num1][num2] == Integer.MAX_VALUE) {
				return -1L;
			} else {
				result += costs[num1][num2];
			}
		}
		return result;
	}

}
