package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReconstructA2RowBinaryMatrix {

	// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/submissions/1597996381/
	public static void main(String[] args) {
		ReconstructA2RowBinaryMatrix test = new ReconstructA2RowBinaryMatrix();
		System.out.println(test.reconstructMatrix(2, 1, new int[] { 1, 1, 1 }));
		System.out.println(test.reconstructMatrix(2, 3, new int[] { 2, 2, 1, 1 }));
		System.out.println(test.reconstructMatrix(5, 5, new int[] { 2, 1, 2, 0, 1, 0, 1, 2, 0, 1 }));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		int length = colsum.length;
		int sum = 0;
		for (int num : colsum) {
			sum += num;
		}
		if (sum != upper + lower) {
			return new ArrayList<>();
		} else {
			int[][] result = new int[2][length];
			for (int i = 0; i < length; i++) {
				if (colsum[i] == 2 || (colsum[i] == 1 && lower < upper)) {
					result[0][i] = 1;
				}
				if (colsum[i] == 2 || (colsum[i] == 1 && result[0][i] == 0)) {
					result[1][i] = 1;
				}
				upper -= result[0][i];
				lower -= result[1][i];
			}
			return lower == 0 && upper == 0 ? new ArrayList(Arrays.asList(result[0], result[1])) : new ArrayList<>();
		}
	}

}
