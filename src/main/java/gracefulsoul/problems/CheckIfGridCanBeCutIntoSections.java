package gracefulsoul.problems;

import java.util.Arrays;

public class CheckIfGridCanBeCutIntoSections {

	// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/submissions/1585531018/
	public static void main(String[] args) {
		CheckIfGridCanBeCutIntoSections test = new CheckIfGridCanBeCutIntoSections();
		System.out.println(test.checkValidCuts(5, new int[][] {
			{ 1, 0, 5, 2 },
			{ 0, 2, 2, 4 },
			{ 3, 2, 5, 3 },
			{ 0, 4, 4, 5 }
		}));
		System.out.println(test.checkValidCuts(4, new int[][] {
			{ 0, 0, 1, 1 },
			{ 2, 0, 3, 4 },
			{ 0, 2, 2, 3 },
			{ 3, 0, 4, 3 }
		}));
		System.out.println(test.checkValidCuts(4, new int[][] {
			{ 0, 2, 2, 4 },
			{ 1, 0, 3, 2 },
			{ 2, 2, 3, 4 },
			{ 3, 0, 4, 2 }
		}));
	}

	public boolean checkValidCuts(int n, int[][] rectangles) {
		return this.checkValidCuts(rectangles, 0) || this.checkValidCuts(rectangles, 1);
	}

	private boolean checkValidCuts(int[][] rectangles, int i) {
		int result = 0;
		Arrays.sort(rectangles, (a, b) -> Integer.compare(a[i], b[i]));
		int prev = rectangles[0][i + 2];
		for (int[] rectangle : rectangles) {
			if (prev <= rectangle[i]) {
				result++;
			}
			prev = Math.max(prev, rectangle[i + 2]);
		}
		return result > 1;
	}

}
