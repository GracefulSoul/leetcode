package gracefulsoul.problems;

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {

	// https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/submissions/1951974781/
	public static void main(String[] args) {
		CountSubmatricesWithTopLeftElementAndSumLessThanK test = new CountSubmatricesWithTopLeftElementAndSumLessThanK();
		System.out.println(test.countSubmatrices(new int[][] {
			{ 7, 6, 3 },
			{ 6, 6, 1 }
		}, 18));
		System.out.println(test.countSubmatrices(new int[][] {
			{ 7, 2, 9 },
			{ 1, 5, 0 },
			{ 2, 6, 6 }
		}, 20));
	}

	public int countSubmatrices(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[] dp = new int[cols];
		int result = 0;
		for (int i = 0; i < rows; i++) {
			int sum = 0;
			for (int j = 0; j < cols; j++) {
				dp[j] += grid[i][j];
				sum += dp[j];
				if (sum <= k) {
					result++;
				}
			}
		}
		return result;
	}

}
