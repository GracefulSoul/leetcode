package gracefulsoul.problems;

public class LargestTriangleArea {

	// https://leetcode.com/problems/largest-triangle-area/submissions/882752370/
	public static void main(String[] args) {
		LargestTriangleArea test = new LargestTriangleArea();
		System.out.println(test.largestTriangleArea(new int[][] {
			{ 0, 0 },
			{ 0, 1 },
			{ 1, 0 },
			{ 0, 2 },
			{ 2, 0 }
		}));
		System.out.println(test.largestTriangleArea(new int[][] {
			{ 1, 0 },
			{ 0, 0 },
			{ 0, 1 }
		}));
	}

	public double largestTriangleArea(int[][] points) {
		double max = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					max = Math.max(max, Math.abs(this.getArea(points[i], points[j], points[k])));
				}
			}
		}
		return max;
	}

	private double getArea(int[] x, int[] y, int[] z) {
		return 0.5 * (x[0] * (y[1] - z[1]) + y[0] * (z[1] - x[1]) + z[0] * (x[1] - y[1]));
	}

}
