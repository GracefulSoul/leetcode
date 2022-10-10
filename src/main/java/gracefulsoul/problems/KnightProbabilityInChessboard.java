package gracefulsoul.problems;

public class KnightProbabilityInChessboard {

	// https://leetcode.com/submissions/detail/819278091/
	public static void main(String[] args) {
		KnightProbabilityInChessboard test = new KnightProbabilityInChessboard();
		System.out.println(test.knightProbability(3, 2, 0, 0));
		System.out.println(test.knightProbability(1, 0, 0, 0));
	}

    private static int[][] DIRECTIONS = {{2, 1}, {-2, 1}, {1, 2}, {-1, 2}, {2, -1}, {-2, -1}, {1, -2}, {-1, -2}};

    public double knightProbability(int n, int k, int row, int column) {
        return this.recursive(n, k, row, column, new double[n / 2 + 1][n / 2 + 1][k + 1]);
    }

    private double recursive(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        row = Math.min(row, n - 1 - row);
        column = Math.min(column, n - 1 - column);
        if (row < column) {
            return this.recursive(n, k, column, row, dp);
        }
        if (dp[row][column][k] != 0.0) {
            return dp[row][column][k];
        }
        double probability = 0.0;
        for (int[] direction : DIRECTIONS) {
            probability += this.recursive(n, k - 1, row + direction[0], column + direction[1], dp) / 8.0;
        }
        dp[row][column][k] = probability;
        return probability;
    }

}
