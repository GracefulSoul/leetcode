package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class NumbersWithSameConsecutiveDifferences {

	// https://leetcode.com/problems/numbers-with-same-consecutive-differences/submissions/1011953675/
	public static void main(String[] args) {
		NumbersWithSameConsecutiveDifferences test = new NumbersWithSameConsecutiveDifferences();
		PrintUtil.print(test.numsSameConsecDiff(3, 7));
		PrintUtil.print(test.numsSameConsecDiff(2, 1));
	}

	public int[] numsSameConsecDiff(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			this.dfs(list, i, 1, n, k);
		}
		int length = list.size();
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private void dfs(List<Integer> list, int item, int i, int n, int k) {
		if (i == n) {
			list.add(item);
		} else {
			int a = item % 10;
			if (k == 0) {
				this.dfs(list, (item * 10) + a, i + 1, n, k);
			} else {
				if ((a + k) <= 9) {
					this.dfs(list, (item * 10) + (a + k), i + 1, n, k);
				}
				if ((a - k) >= 0) {
					this.dfs(list, (item * 10) + (a - k), i + 1, n, k);
				}
			}
		}
	}

}
