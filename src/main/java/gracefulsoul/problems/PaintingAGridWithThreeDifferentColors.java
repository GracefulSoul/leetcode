package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PaintingAGridWithThreeDifferentColors {

	// https://leetcode.com/problems/painting-a-grid-with-three-different-colors/submissions/1637079527/
	public static void main(String[] args) {
		PaintingAGridWithThreeDifferentColors test = new PaintingAGridWithThreeDifferentColors();
		System.out.println(test.colorTheGrid(1, 1));
		System.out.println(test.colorTheGrid(1, 2));
		System.out.println(test.colorTheGrid(5, 5));
	}

	private static final int MOD = 1_000_000_007;

	@SuppressWarnings("unchecked")
	public int colorTheGrid(int m, int n) {
		int total = 1;
		for (int i = 0; i < m; i++) {
			total *= 3;
		}
		int[][] dp = new int[n + 1][total];
		int[][] rowValid = new int[total][total];
		List<Integer> good = new ArrayList<>();
		List<Integer>[] pattern = new ArrayList[total];
		for (int i = 0; i < total; i++) {
			pattern[i] = new ArrayList<>();
		}
		for (int i = 0; i < total; i++) {
			int val = i;
			int valid = 1;
			for (int j = 0; j < m; j++) {
				pattern[i].add(val % 3);
				val /= 3;
			}
			for (int j = 1; j < m; j++) {
				if (pattern[i].get(j).equals(pattern[i].get(j - 1))) {
					valid = 0;
				}
			}
			if (valid == 1) {
				good.add(i);
			}
		}
		for (int i : good) {
			dp[1][i] = 1;
		}
		for (int i : good) {
			for (int j : good) {
				rowValid[i][j] = 1;
				for (int k = 0; k < m; k++) {
					if (pattern[i].get(k).equals(pattern[j].get(k))) {
						rowValid[i][j] = 0;
					}
				}
			}
		}
		for (int col = 2; col <= n; col++) {
			for (int i : good) {
				long sum = 0;
				for (int j : good) {
					if (rowValid[i][j] == 1) {
						sum += dp[col - 1][j];
					}
				}
				dp[col][i] = (int) (sum % MOD);
			}
		}
		long result = 0;
		for (int i = 0; i < total; i++) {
			result += dp[n][i];
		}
		return (int) (result % MOD);
	}

}
