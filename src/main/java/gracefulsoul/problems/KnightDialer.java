package gracefulsoul.problems;

import java.util.Arrays;

public class KnightDialer {

	// https://leetcode.com/problems/knight-dialer/submissions/976989957/
	public static void main(String[] args) {
		KnightDialer test = new KnightDialer();
		System.out.println(test.knightDialer(1));
		System.out.println(test.knightDialer(2));
		System.out.println(test.knightDialer(3131));
	}

	public int knightDialer(int n) {
		int mod = 1000000007;
		if (n == 1) {
			return 10;
		}
		int[][] graph = {
			{ 4, 6 },
			{ 6, 8 },
			{ 7, 9 },
			{ 4, 8 },
			{ 3, 9, 0 },
			{},
			{ 1, 7, 0 },
			{ 2, 6 },
			{ 1, 3 },
			{ 2, 4 }
		};
		int[] dp = new int[10];
		Arrays.fill(dp, 1);
		while (n-- > 1) {
			int[] temp = new int[10];
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[i].length; j++) {
					int position = graph[i][j];
					temp[position] = (temp[position] + dp[i] % mod) % mod;
				}
			}
			dp = temp;
		}
		int result = 0;
		for (int num : dp) {
			result = (result + num % mod) % mod;
		}
		return result;
	}

}
