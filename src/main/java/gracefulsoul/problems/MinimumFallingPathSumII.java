package gracefulsoul.problems;

public class MinimumFallingPathSumII {

	// https://leetcode.com/problems/minimum-falling-path-sum-ii/submissions/1242375372/
	public static void main(String[] args) {
		MinimumFallingPathSumII test = new MinimumFallingPathSumII();
		System.out.println(test.minFallingPathSum(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		}));
		System.out.println(test.minFallingPathSum(new int[][] {
			{ 7 }
		}));
	}

	public int minFallingPathSum(int[][] grid) {
		int length = grid.length;
		for (int i = 1; i < length; i++) {
			int[] min = this.getMinTwoNumbers(grid[i - 1]);
			for (int j = 0; j < length; j++) {
				if (grid[i - 1][j] == min[0]) {
					grid[i][j] += min[1];
				} else {
					grid[i][j] += min[0];
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int num : grid[length - 1]) {
			result = Math.min(result, num);
		}
		return result;
	}

	private int[] getMinTwoNumbers(int[] nums) {
		int[] min = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
		for (int num : nums) {
			if (min[0] > num) {
				min[1] = min[0];
				min[0] = num;
			} else if (min[1] > num) {
				min[1] = num;
			}
		}
		return min;
	}

}
