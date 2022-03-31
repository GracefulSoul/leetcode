package gracefulsoul.problems;

public class KthSmallestInLexicographicalOrder {

	// https://leetcode.com/submissions/detail/670737288/
	public static void main(String[] args) {
		KthSmallestInLexicographicalOrder test = new KthSmallestInLexicographicalOrder();
		System.out.println(test.findKthNumber(13, 2));
		System.out.println(test.findKthNumber(1, 1));
	}

	public int findKthNumber(int n, int k) {
		long cur = 1;
		while (k > 1) {
			long step = this.getStep(n, cur, cur + 1);
			if (step <= k - 1) {
				cur++;
				k -= step;
			} else {
				cur *= 10;
				k--;
			}
		}
		return (int) cur;
	}

	private long getStep(int n, long num1, long num2) {
		long count = 0;
		while (num1 <= n) {
			count += Math.min(n + 1, num2) - num1;
			num1 *= 10;
			num2 *= 10;
		}
		return count;
	}

}
