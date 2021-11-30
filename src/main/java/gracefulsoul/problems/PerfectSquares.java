package gracefulsoul.problems;

public class PerfectSquares {

	// https://leetcode.com/submissions/detail/594658661/
	public static void main(String[] args) {
		PerfectSquares test = new PerfectSquares();
		System.out.println(test.numSquares(12));
		System.out.println(test.numSquares(13));
	}

	public int numSquares(int n) {
		for (int idx = 1; idx < n; idx++) {
			if (this.recursive(n, idx)) {
				return idx;
			}
		}
		return n;
	}

	private boolean recursive(int n, int count) {
		if (count == 1) {
			return Math.abs(Math.pow((int) Math.sqrt(n), 2) - n) < 1e-5;
		} else {
			for (int idx = 1; idx * idx <= n; idx++) {
				if (this.recursive(n - idx * idx, count - 1)) {
					return true;
				}
			}
			return false;
		}
	}

}
