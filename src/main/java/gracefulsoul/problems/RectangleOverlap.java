package gracefulsoul.problems;

public class RectangleOverlap {

	// https://leetcode.com/problems/rectangle-overlap/submissions/895688314/
	public static void main(String[] args) {
		RectangleOverlap test = new RectangleOverlap();
		System.out.println(test.isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 }));
		System.out.println(test.isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 }));
		System.out.println(test.isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 2, 2, 3, 3 }));
	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
	}

}
