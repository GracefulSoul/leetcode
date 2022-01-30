package gracefulsoul.problems;

public class MaxSumOfRectangleNoLargerThanK {

	// https://leetcode.com/submissions/detail/629365987/
	public static void main(String[] args) {
		MaxSumOfRectangleNoLargerThanK test = new MaxSumOfRectangleNoLargerThanK();
		System.out.println(test.maxSumSubmatrix(new int[][] {
			new int[] { 1, 0, 1 },
			new int[] { 0, -2, 3 }
		}, 2));
		System.out.println(test.maxSumSubmatrix(new int[][] {
			new int[] { 2, 2, -1 }
		}, 3));
	}

	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < col; i++) {
			int[] nums = new int[row];
			for (int j = i; j < col; j++) {
				for (int l = 0; l < row; l++) {
					nums[l] += matrix[l][j];
				}
				max = Math.max(max, this.getMaxSubSum(nums, row, k));
				if (max == k) {
					return k;
				}
			}
		}
		return max;
	}

	private int getMaxSubSum(int[] nums, int row, int k) {
		int curr = nums[0];
		int max = curr;
		for (int idx = 1; idx < row; idx++) {
			curr = Math.max(curr + nums[idx], nums[idx]);
			if (curr > max) {
				max = curr;
			}
		}
		if (max <= k) {
			return max;
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			curr = 0;
			for (int j = i; j < row; j++) {
				curr += nums[j];
				if (curr > max && curr <= k) {
					max = curr;
				}
				if (max == k) {
					return k;
				}
			}
		}
		return max;
	}

}
