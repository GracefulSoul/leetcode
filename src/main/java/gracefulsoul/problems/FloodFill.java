package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FloodFill {

	// https://leetcode.com/submissions/detail/848532308/
	public static void main(String[] args) {
		FloodFill test = new FloodFill();
		PrintUtil.print(test.floodFill(new int[][] {
			{ 1, 1, 1 },
			{ 1, 1, 0 },
			{ 1, 0, 1 }
		}, 1, 1, 2));
		PrintUtil.print(test.floodFill(new int[][] {
			{ 0, 0, 0 },
			{ 0, 0, 0 }
		}, 0, 0, 0));

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] != color) {
			this.dfs(image, sr, sc, image[sr][sc], color);
		}
		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == color) {
			image[sr][sc] = newColor;
			this.dfs(image, sr + 1, sc, color, newColor);
			this.dfs(image, sr - 1, sc, color, newColor);
			this.dfs(image, sr, sc + 1, color, newColor);
			this.dfs(image, sr, sc - 1, color, newColor);
		}
	}

}
