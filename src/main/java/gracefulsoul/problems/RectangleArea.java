package gracefulsoul.problems;

public class RectangleArea {

	// https://leetcode.com/submissions/detail/578782003/
	public static void main(String[] args) {
		RectangleArea test = new RectangleArea();
		System.out.println(test.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
		System.out.println(test.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}

	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		int y = Math.min(ay2, by2) - Math.max(ay1, by1);
		if (x > 0 && y > 0) {
			return ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1)) - (x * y);
		} else {
			return ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1));
		}
	}

}
