package gracefulsoul.problems;

public class UniquePaths {

	// https://leetcode.com/submissions/detail/506597064/
	public static void main(String[] args) {
		UniquePaths test = new UniquePaths();
		System.out.println(test.uniquePaths(3, 7));
//		System.out.println(test.uniquePaths(3, 2));
//		System.out.println(test.uniquePaths(7, 3));
//		System.out.println(test.uniquePaths(3, 3));
	}

	public int uniquePaths(int m, int n) {
		return this.recursiveUniquePaths(m - 1, n - 1, new int[n][m]);
	}

	private int recursiveUniquePaths(int m, int n, int[][] path) {
		if (m == 0 || n == 0) {
			return 1;
		} else if (path[n][m] > 0) {
			return path[n][m];
		} else {
			path[n][m] = this.recursiveUniquePaths(m - 1, n, path) + this.recursiveUniquePaths(m, n - 1, path);
			return path[n][m];
		}
	}

}
