package gracefulsoul.problems;

public class FlippingAnImage {

	// https://leetcode.com/problems/flipping-an-image/submissions/893253172/
	public static void main(String[] args) {
		FlippingAnImage test = new FlippingAnImage();
		System.out.println(test.flipAndInvertImage(new int[][] {
			{ 1, 1, 0 },
			{ 1, 0, 1 },
			{ 0, 0, 0 }
		}));
		System.out.println(test.flipAndInvertImage(new int[][] {
			{ 1, 1, 0, 0 },
			{ 1, 0, 0, 1 },
			{ 0, 1, 1, 1 },
			{ 1, 0, 1, 0 }
		}));
	}

	public int[][] flipAndInvertImage(int[][] image) {
		int length = image[0].length;
		for (int[] row : image) {
			for (int left = 0, right = length - 1; left <= right; left++, right--) {
				int temp = row[left];
				row[left] = 1 - row[right];
				row[right] = 1 - temp;
			}
		}
		return image;
	}

}
