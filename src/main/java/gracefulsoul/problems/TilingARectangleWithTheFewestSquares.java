package gracefulsoul.problems;

public class TilingARectangleWithTheFewestSquares {

	// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/submissions/1556685628/
	public static void main(String[] args) {
		TilingARectangleWithTheFewestSquares test = new TilingARectangleWithTheFewestSquares();
		System.out.println(test.tilingRectangle(2, 3));
		System.out.println(test.tilingRectangle(5, 8));
		System.out.println(test.tilingRectangle(11, 13));
	}

	public int tilingRectangle(int n, int m) {
		return calculate(n, m, new int[Math.min(m, n) + 1][Math.max(m, n) + 1]);
	}

	private int calculate(int n, int m, int[][] memory) {
		if (n > m) {
			return this.calculate(m, n, memory);
		} else if (memory[n][m] != 0) {
			return memory[n][m];
		} else if (n == 0) {
			memory[n][m] = 0;
		} else if (n == 1) {
			memory[n][m] = m;
		} else if (m == n) {
			memory[n][m] = 1;
		} else if (m % n == 0) {
			memory[n][m] = m / n;
		} else if (m > 2 * n) {
			int count = m / n - 1;
			memory[n][m] = count + this.calculate(n, m - count * n, memory);
		} else {
			memory[n][m] = 1 + this.calculate(n, m - n, memory);
			for (int i = (m + 1) / 2; i < n; i++) {
				for (int j = 0; j <= m - i; j++) {
					memory[n][m] = Math.min(memory[n][m],
							2 + this.calculate(n - i, i + j, memory)
								+ this.calculate(n - (m - i), (m - i) - j, memory)
								+ this.calculate(j, i - (m - i), memory));
				}
			}
		}
		return memory[n][m];
	}

}
