package gracefulsoul.problems;

public class NextGreaterNumericallyBalancedNumber {

	// https://leetcode.com/problems/next-greater-numerically-balanced-number/submissions/1810246229/
	public static void main(String[] args) {
		NextGreaterNumericallyBalancedNumber test = new NextGreaterNumericallyBalancedNumber();
		System.out.println(test.nextBeautifulNumber(1));
		System.out.println(test.nextBeautifulNumber(1000));
		System.out.println(test.nextBeautifulNumber(3000));
	}

	public int nextBeautifulNumber(int n) {
		int[] counts = { 0, 1, 2, 3, 4, 5, 6 };
		int length = String.valueOf(n).length();
		for (int i = 0; i <= 6; i++) {
			counts[i]--;
			int result = this.dfs(counts, i, length, n);
			if (result > 0) {
				return result;
			}
			counts[i]++;
		}
		return this.dfs(counts, 1, length, n);
	}

	private int dfs(int[] counts, int num, int n, int limit) {
		if (n == 0) {
			if (num <= limit) {
				return 0;
			}
			for (int i = 1; i < counts.length; i++) {
				if (counts[i] != 0 && counts[i] != i) {
					return 0;
				}
			}
			return num;
		}
		for (int i = 1; i <= 6; i++) {
			if (counts[i] > 0) {
				counts[i]--;
				int result = this.dfs(counts, num * 10 + i, n - 1, limit);
				if (result > 0) {
					return result;
				}
				counts[i]++;
			}
		}
		return 0;
	}

}
