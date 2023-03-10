package gracefulsoul.problems;

public class ReorderedPowerOf2 {

	// https://leetcode.com/problems/reordered-power-of-2/submissions/912626766/
	public static void main(String[] args) {
		ReorderedPowerOf2 test = new ReorderedPowerOf2();
		System.out.println(test.reorderedPowerOf2(1));
		System.out.println(test.reorderedPowerOf2(10));
	}

	public boolean reorderedPowerOf2(int n) {
		long count = this.getCount(n);
		for (int i = 0; i < 32; i++) {
			if (this.getCount(1 << i) == count) {
				return true;
			}
		}
		return false;
	}

	private long getCount(int n) {
		long count = 0;
		while (n > 0) {
			count += (int) Math.pow(10, n % 10);
			n /= 10;
		}
		return count;
	}

}
