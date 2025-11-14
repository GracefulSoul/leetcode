package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class IncrementSubmatricesByOne {

	// https://leetcode.com/problems/increment-submatrices-by-one/submissions/1829585671/
	public static void main(String[] args) {
		IncrementSubmatricesByOne test = new IncrementSubmatricesByOne();
		PrintUtil.print(test.rangeAddQueries(3, new int[][] {
			{ 1, 1, 2, 2 },
			{ 0, 0, 1, 1 }
		}));
		PrintUtil.print(test.rangeAddQueries(2, new int[][] {
			{ 0, 0, 1, 1 }
		}));
	}

	public int[][] rangeAddQueries(int n, int[][] queries) {
		int[][] result = new int[n][n];
		for (int[] query : queries) {
			result[query[0]][query[1]]++;
			if (query[2] + 1 < n) {
				result[query[2] + 1][query[1]]--;
			}
			if (query[3] + 1 < n) {
				result[query[0]][query[3] + 1]--;
			}
			if (query[2] + 1 < n && query[3] + 1 < n) {
				result[query[2] + 1][query[3] + 1]++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (0 < i) {
					result[i][j] += result[i - 1][j];
				}
				if (0 < j) {
					result[i][j] += result[i][j - 1];
				}
				if (0 < i && 0 < j) {
					result[i][j] -= result[i - 1][j - 1];
				}
			}
		}
		return result;
	}

}
