package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	// https://leetcode.com/submissions/detail/640983194/
	public static void main(String[] args) {
		LexicographicalNumbers test = new LexicographicalNumbers();
		System.out.println(test.lexicalOrder(13));
		System.out.println(test.lexicalOrder(2));
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for (int idx = 1; idx < 10; idx++) {
			this.dfs(result, n, idx);
		}
		return result;
	}

	private void dfs(List<Integer> result, int n, int curr) {
		if (curr > n) {
			return;
		}
		result.add(curr);
		for (int idx = 0; idx < 10; idx++) {
			if ((10 * curr) + idx > n) {
				return;
			}
			this.dfs(result, n, (10 * curr) + idx);
		}
	}

}
