package gracefulsoul.problems;

public class FillingBookcaseShelves {

	// https://leetcode.com/problems/filling-bookcase-shelves/submissions/1254051490/
	public static void main(String[] args) {
		FillingBookcaseShelves test = new FillingBookcaseShelves();
		System.out.println(test.minHeightShelves(new int[][] {
			{ 1, 1 },
			{ 2, 3 },
			{ 2, 3 },
			{ 1, 1 },
			{ 1, 1 },
			{ 1, 1 },
			{ 1, 2 }
		} , 4));
		System.out.println(test.minHeightShelves(new int[][] {
			{ 1, 3 },
			{ 2, 4 },
			{ 3, 2 }
		} , 6));
	}

	public int minHeightShelves(int[][] books, int shelfWidth) {
		int length = books.length;
		int[] dp = new int[length + 1];
		for (int i = 1; i <= length; i++) {
			int width = books[i - 1][0];
			int height = books[i - 1][1];
			dp[i] = dp[i - 1] + height;
			for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelfWidth; j--) {
				height = Math.max(height, books[j - 1][1]);
				width += books[j - 1][0];
				dp[i] = Math.min(dp[i], dp[j - 1] + height);
			}
		}
		return dp[length];
	}

}
