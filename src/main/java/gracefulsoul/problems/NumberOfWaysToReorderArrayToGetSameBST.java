package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToReorderArrayToGetSameBST {

	// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/submissions/972538785/
	public static void main(String[] args) {
		NumberOfWaysToReorderArrayToGetSameBST test = new NumberOfWaysToReorderArrayToGetSameBST();
		System.out.println(test.numOfWays(new int[] { 2, 1, 3 }));
		System.out.println(test.numOfWays(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(test.numOfWays(new int[] { 1, 2, 3 }));
	}

	private static final int MOD = 1000000007;

	public int numOfWays(int[] nums) {
		int length = nums.length;
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		return (int) this.dfs(list, this.getTriangle(length + 1)) - 1;
	}

	private long dfs(List<Integer> list, long[][] triangle) {
		if (list.size() <= 2) {
			return 1;
		}
		int root = list.get(0);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int n : list) {
			if (n < root) {
				left.add(n);
			} else if (n > root) {
				right.add(n);
			}
		}
		return ((triangle[list.size() - 1][left.size()] * (((this.dfs(left, triangle) % MOD) * (this.dfs(right, triangle) % MOD)) % MOD)) % MOD) % MOD;
	}

	private long[][] getTriangle(int length) {
		long[][] triangle = new long[length][length];
		for (int i = 0; i < length; i++) {
			triangle[i][0] = triangle[i][i] = 1;
		}
		for (int i = 2; i < length; i++) {
			for (int j = 1; j < i; j++) {
				triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
			}
		}
		return triangle;
	}

}
