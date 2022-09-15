package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ImageSmoother {

	// https://leetcode.com/submissions/detail/800377895/
	public static void main(String[] args) {
		ImageSmoother test = new ImageSmoother();
		PrintUtil.print(test.imageSmoother(new int[][] {
			{ 1, 1, 1 },
			{ 1, 0, 1 },
			{ 1, 1, 1 }
		}));
		PrintUtil.print(test.imageSmoother(new int[][] {
			{ 100, 200, 100 },
			{ 200, 50, 200 },
			{ 100, 200, 100 }
		}));
	}

	public int[][] imageSmoother(int[][] img) {
		int row = img.length;
		int col = img[0].length;
		int[][] result = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = this.check(img, row, col, i, j);
			}
		}
		return result;
	}

	private int check(int[][] img, int row, int col, int i, int j) {
		int count = 1;
		int sum = img[i][j];
		if (i - 1 >= 0) {
			count++;
			sum += img[i - 1][j];
			if (j - 1 >= 0) {
				count++;
				sum += img[i - 1][j - 1];
			}
			if (j + 1 < col) {
				count++;
				sum += img[i - 1][j + 1];
			}
		}
		if (j - 1 >= 0) {
			count++;
			sum += img[i][j - 1];
		}
		if (j + 1 < col) {
			count++;
			sum += img[i][j + 1];
		}
		if (i + 1 < row) {
			count++;
			sum += img[i + 1][j];
			if (j - 1 >= 0) {
				count++;
				sum += img[i + 1][j - 1];
			}
			if (j + 1 < col) {
				count++;
				sum += img[i + 1][j + 1];
			}
		}
		return sum / count;
	}

}
