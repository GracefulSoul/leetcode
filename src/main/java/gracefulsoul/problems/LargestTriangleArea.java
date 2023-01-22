package gracefulsoul.problems;

public class LargestTriangleArea {

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
		double result = 0;
		for (int[] i : points) {
			for (int[] j : points) {
				for (int[] k : points) {
					result = Math.max(result, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
				}
			}
		}
		return result;
	}

}
