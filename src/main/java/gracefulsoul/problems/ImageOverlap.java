package gracefulsoul.problems;

public class ImageOverlap {

	// https://leetcode.com/problems/image-overlap/submissions/895306409/
	public static void main(String[] args) {
		ImageOverlap test = new ImageOverlap();
		System.out.println(test.largestOverlap(new int [][] {
			{ 1, 1, 0 },
			{ 0, 1, 0 },
			{ 0, 1, 0 }
		}, new int[][] {
			{ 0, 0, 0 },
			{ 0, 1, 1 },
			{ 0, 0, 1 }
		}));
		System.out.println(test.largestOverlap(new int [][] {
			{ 1 }
		}, new int[][] {
			{ 1 }
		}));
		System.out.println(test.largestOverlap(new int [][] {
			{ 0 }
		}, new int[][] {
			{ 0 }
		}));
	}

	public int largestOverlap(int[][] img1, int[][] img2) {
		int length = img1.length;
		int[][] count = new int[(2 * length) + 1][(2 * length) + 1];
		for (int x1 = 0; x1 < length; x1++) {
			for (int y1 = 0; y1 < length; y1++) {
				if (img1[x1][y1] == 1) {
					for (int x2 = 0; x2 < length; x2++) {
						for (int y2 = 0; y2 < length; y2++) {
							if (img2[x2][y2] == 1) {
								count[x1 - x2 + length][y1 - y2 + length]++;
							}
						}
					}
				}
			}
		}
		int result = 0;
		for (int[] row : count) {
			for (int value : row) {
				result = Math.max(result, value);
			}
		}
		return result;
	}

}
