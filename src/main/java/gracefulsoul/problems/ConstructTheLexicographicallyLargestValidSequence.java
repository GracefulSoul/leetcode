package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ConstructTheLexicographicallyLargestValidSequence {

	// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/submissions/1544785866/
	public static void main(String[] args) {
		ConstructTheLexicographicallyLargestValidSequence test = new ConstructTheLexicographicallyLargestValidSequence();
		PrintUtil.print(test.constructDistancedSequence(3));
		PrintUtil.print(test.constructDistancedSequence(5));
	}

	public int[] constructDistancedSequence(int n) {
		int[] result = new int[(n * 2) - 1];
		boolean[] visited = new boolean[n + 1];
		this.backtrack(n, result, 0, visited);
		return result;
	}

	private boolean backtrack(int n, int[] result, int index, boolean[] visited) {
		if (index == result.length) {
			return true;
		} else if (result[index] != 0) {
			return this.backtrack(n, result, index + 1, visited);
		} else {
			for (int i = n; i >= 1; i--) {
				if (!visited[i]) {
					visited[i] = true;
					result[index] = i;
					if (i == 1) {
						if (this.backtrack(n, result, index + 1, visited)) {
							return true;
						}
					} else if (index + i < result.length && result[index + i] == 0) {
						result[index + i] = i;
						if (this.backtrack(n, result, index + 1, visited)) {
							return true;
						}
						result[index + i] = 0;
					}
					result[index] = 0;
					visited[i] = false;
				}
			}
			return false;
		}
	}

}
