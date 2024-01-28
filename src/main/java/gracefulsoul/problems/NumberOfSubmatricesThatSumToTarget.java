package gracefulsoul.problems;

public class NumberOfSubmatricesThatSumToTarget {

	// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/submissions/1158705432/
	public static void main(String[] args) {
		NumberOfSubmatricesThatSumToTarget test = new NumberOfSubmatricesThatSumToTarget();
		System.out.println(test.numSubmatrixSumTarget(new int[][] {
			{ 0, 1, 0 },
			{ 1, 1, 1 },
			{ 0, 1, 0 }
		}, 0));
		System.out.println(test.numSubmatrixSumTarget(new int[][] {
			{ 1, -1 },
			{ -1, 1 }
		}, 0));
		System.out.println(test.numSubmatrixSumTarget(new int[][] {
			{ 904 }
		}, 0));
	}

	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			int[] dp = new int[col];
			for (int j = i; j < row; j++) {
				for (int k = 0; k < col; k++) {
					dp[k] += matrix[j][k];
				}
				for (int l = 0; l < col; l++) {
					int sum = 0;
					for (int m = l; m < col; m++) {
						sum += dp[m];
						if (sum == target) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

}
