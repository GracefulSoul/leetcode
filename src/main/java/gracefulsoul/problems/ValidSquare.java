package gracefulsoul.problems;

public class ValidSquare {

	// https://leetcode.com/submissions/detail/755102078/
	public static void main(String[] args) {
		ValidSquare test = new ValidSquare();
		System.out.println(test.validSquare(
				new int[] { 0, 0 },
				new int[] { 1, 1 },
				new int[] { 1, 0 },
				new int[] { 0, 1 }
		));
		System.out.println(test.validSquare(
				new int[] { 0, 0 },
				new int[] { 1, 1 },
				new int[] { 1, 0 },
				new int[] { 0, 12 }
		));
		System.out.println(test.validSquare(
				new int[] { 1, 0 },
				new int[] { -1, 0 },
				new int[] { 0, 1 },
				new int[] { 0, -1 }
		));
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		long a = this.getDistance(p1, p2);
		long b = this.getDistance(p1, p3);
		long c = this.getDistance(p1, p4);
		if (a != this.getDistance(p3, p4) || b != this.getDistance(p2, p4) || c != this.getDistance(p2, p3) ||
				a == 0 || b == 0 || c == 0) {
			return false;
		} else {
			return a == b || b == c || a == c;
		}
	}
    
    private long getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

}
