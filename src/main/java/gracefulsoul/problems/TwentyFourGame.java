package gracefulsoul.problems;

public class TwentyFourGame {

	// https://leetcode.com/submissions/detail/813100051/
	public static void main(String[] args) {
		TwentyFourGame test = new TwentyFourGame();
		System.out.println(test.judgePoint24(new int[] { 4, 1, 8, 7 }));
		System.out.println(test.judgePoint24(new int[] { 1, 2, 1, 2 }));
	}

	public boolean judgePoint24(int[] cards) {
		return this.dfs(new double[] { cards[0], cards[1], cards[2], cards[3] });
	}

	private boolean dfs(double[] cards) {
		int length = cards.length;
		if (length == 1) {
			return Math.abs(cards[0] - 24) < 0.001;
		}
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				double[] temp = new double[length - 1];
				for (int k = 0, index = 0; k < length; k++) {
					if (k != i && k != j) {
						temp[index++] = cards[k];
					}
				}
				for (double d : this.compute(cards[i], cards[j])) {
					temp[temp.length - 1] = d;
					if (this.dfs(temp)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private double[] compute(double a, double b) {
		return new double[] { a + b, a - b, b - a, a * b, a / b, b / a };
	}

}
