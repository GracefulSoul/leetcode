package gracefulsoul.problems;

public class KthSmallestElementInASortedMatrix {

	// https://leetcode.com/submissions/detail/636319932/
	public static void main(String[] args) {
		KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
		System.out.println(test.kthSmallest(new int[][] {
			new int[] { 1, 5, 9 },
			new int[] { 10, 11, 13 },
			new int[] { 12, 13, 15 }
		}, 8));
		System.out.println(test.kthSmallest(new int[][] {
			new int[] { -5 }
		}, 1));
	}

	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		int low = matrix[0][0];
		int high = matrix[row - 1][col - 1];
		while (low < high) {
			int mid = low + ((high - low) / 2);
			if (this.getCount(matrix, row, col, mid) < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private int getCount(int[][] matrix, int row, int col, int mid) {
		int count = 0;
		int j = col - 1;
		for (int i = 0; i < row; i++) {
			while (j >= 0 && matrix[i][j] > mid) {
				j--;
			}
			count += j + 1;
		}
		return count;
	}

}
