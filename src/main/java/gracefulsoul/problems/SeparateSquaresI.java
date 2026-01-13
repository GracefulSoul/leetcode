package gracefulsoul.problems;

public class SeparateSquaresI {

	// https://leetcode.com/problems/separate-squares-i/submissions/1883659407/
	public static void main(String[] args) {
		SeparateSquaresI test = new SeparateSquaresI();
		System.out.println(test.separateSquares(new int[][] { { 0, 0, 1 }, { 2, 2, 1 } }));
		System.out.println(test.separateSquares(new int[][] { { 0, 0, 2 }, { 1, 1, 1 } }));
	}

	public double separateSquares(int[][] squares) {
		double area = 0.0;
		double low = 0;
		double high = 2 * 1e9;
		for (int[] square : squares) {
			double y = square[1];
			double l = square[2];
			area += l * l;
			low = Math.min(low, y);
			high = Math.max(high, y + l);
		}
		double half = area / 2.0;
		for (int i = 0; i < 60; i++) {
			double mid = (low + high) / 2.0;
			if (this.separateSquares(squares, mid) < half) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return high;
	}

	private double separateSquares(int[][] squares, double height) {
		double area = 0.0;
		for (int[] square : squares) {
			double y = square[1];
			double l = square[2];
			if (height <= y) {
				continue;
			} else if (height >= y + l) {
				area += l * l;
			} else {
				area += l * (height - y);
			}
		}
		return area;
	}

}
