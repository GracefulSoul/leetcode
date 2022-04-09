package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class CountingBits {

	// https://leetcode.com/submissions/detail/619609975/
	public static void main(String[] args) {
		CountingBits test = new CountingBits();
		PrintUtil.print(test.countBits(2));
		PrintUtil.print(test.countBits(5));
	}

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int idx = 1; idx <= n; idx++) {
			result[idx] = result[idx & (idx - 1)] + 1;
		}
		return result;
	}

}
