package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	// https://leetcode.com/submissions/detail/640979957/
	public static void main(String[] args) {
		LexicographicalNumbers test = new LexicographicalNumbers();
		System.out.println(test.lexicalOrder(13));
		System.out.println(test.lexicalOrder(2));
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for (int idx = 1; idx < 10; idx++) {
			this.dfs(idx, n, result);
		}
		return result;
	}

	private void dfs(int cur, int n, List<Integer> res) {
		if (cur > n) {
			return;
		}
		res.add(cur);
		for (int idx = 0; idx < 10; idx++) {
			int num = (10 * cur) + idx;
			if (num > n) {
				return;
			}
			this.dfs(num, n, res);
		}
	}

}
