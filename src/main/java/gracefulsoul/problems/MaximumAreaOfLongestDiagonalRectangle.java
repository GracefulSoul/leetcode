package gracefulsoul.problems;

public class MaximumAreaOfLongestDiagonalRectangle {

	// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/submissions/1748833504/
	public static void main(String[] args) {
		MaximumAreaOfLongestDiagonalRectangle test = new MaximumAreaOfLongestDiagonalRectangle();
		System.out.println(test.areaOfMaxDiagonal(new int[][] {
			{ 9, 3 },
			{ 8, 6 }
		}));
		System.out.println(test.areaOfMaxDiagonal(new int[][] {
			{ 3, 4 },
			{ 4, 3 }
		}));
	}

	public int areaOfMaxDiagonal(int[][] dimensions) {
		int result = 0;
		int max = 0;
		for (int[] dimension : dimensions) {
			int diagonal = (dimension[0] * dimension[0]) + (dimension[1] * dimension[1]);
			int area = dimension[0] * dimension[1];
			if (max < diagonal || (diagonal == max && result < area)) {
				max = diagonal;
				result = area;
			}
		}
		return result;
	}

}
