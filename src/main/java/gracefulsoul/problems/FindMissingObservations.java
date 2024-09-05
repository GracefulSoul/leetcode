package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class FindMissingObservations {

	// https://leetcode.com/problems/find-missing-observations/submissions/1379829084/
	public static void main(String[] args) {
		FindMissingObservations test = new FindMissingObservations();
		PrintUtil.print(test.missingRolls(new int[] { 3, 2, 4, 3 }, 4, 2));
		PrintUtil.print(test.missingRolls(new int[] { 1, 5, 6 }, 3, 4));
		PrintUtil.print(test.missingRolls(new int[] { 1, 2, 3, 4 }, 6, 4));
	}

	public int[] missingRolls(int[] rolls, int mean, int n) {
		int sum = 0;
		for (int roll : rolls) {
			sum += roll;
		}
		int less = (mean * (n + rolls.length)) - sum;
		if (less < n || (6 * n) < less) {
			return new int[0];
		} else {
			int quotient = less / n;
			int remainder = less % n;
			int[] result = new int[n];
			Arrays.fill(result, quotient);
			for (int i = 0; i < remainder; i++) {
				result[i] = quotient + 1;
			}
			for (int i = remainder; i < n; i++) {
				result[i] = quotient;
			}
			return result;
		}
	}

}
