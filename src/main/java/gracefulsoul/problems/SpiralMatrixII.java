package gracefulsoul.problems;

import java.util.Arrays;

public class SpiralMatrixII {

	// https://leetcode.com/submissions/detail/504834978/
	public static void main(String[] args) {
		SpiralMatrixII test = new SpiralMatrixII();
		print(test.generateMatrix(3));
		print(test.generateMatrix(1));
	}

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int min = 0;
		int max = n - 1;
		int num = 1;
		while (num <= n * n) {
			for (int idx = min; idx <= max && num <= n * n; idx++) {
				result[min][idx] = num++;
			}
			for (int idx = min + 1; idx <= max - 1 && num <= n * n; idx++) {
				result[idx][max] = num++;
			}
			for (int idx = max; idx >= min && num <= n * n; idx--) {
				result[max][idx] = num++;
			}
			for (int idx = max - 1; idx >= min + 1 && num <= n * n; idx--) {
				result[idx][min] = num++;
			}
			min++;
			max--;
		}
		return result;
	}

	private static void print(int[][] matrix) {
		for (int[] array : matrix) {
			System.out.println(Arrays.toString(array));
		}
	}

}
