package gracefulsoul.problems;

import java.util.Arrays;

public class FindTheShortestSuperstring {

	// https://leetcode.com/problems/find-the-shortest-superstring/submissions/990872322/
	public static void main(String[] args) {
		FindTheShortestSuperstring test = new FindTheShortestSuperstring();
		System.out.println(test.shortestSuperstring(new String[] { "alex", "loves", "leetcode" }));
		System.out.println(test.shortestSuperstring(new String[] { "catg", "ctaagt", "gcta", "ttca", "atgcatc" }));
	}

	public String shortestSuperstring(String[] words) {
		int length = words.length;
		int[][] min = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					continue;
				}
				min[i][j] = this.getCost(words, i, j);
			}
		}
		int size = 1 << length;
		int[][] dp = new int[size][length];
		int[][] parent = new int[size][length];
		for (int i = 0; i < size; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
			Arrays.fill(parent[i], -1);
		}
		for (int i = 0; i < length; i++) {
			dp[1 << i][i] = words[i].length();
		}
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < length; j++) {
				if ((i & (1 << j)) == 0) {
					continue;
				}
				int state = i & ~(1 << j);
				for (int k = 0; k < length; k++) {
					if (k == j) {
						continue;
					}
					if (dp[i][j] > dp[state][k] + min[k][j]) {
						dp[i][j] = dp[state][k] + min[k][j];
						parent[i][j] = k;
					}
				}
			}
		}
		int state = size - 1;
		int path = dp[state][0];
		int curr = 0;
		for (int i = 0; i < length; i++) {
			if (dp[state][i] < path) {
				path = dp[state][i];
				curr = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (state > 0) {
			int prev = parent[state][curr];
			if (prev < 0) {
				sb.insert(0, words[curr]);
			} else {
				sb.insert(0, words[curr].substring(words[curr].length() - min[prev][curr]));
			}
			state &= ~(1 << curr);
			curr = prev;
		}
		return sb.toString();
	}

	private int getCost(String[] words, int i, int j) {
		int minLength = Math.min(words[i].length(), words[j].length());
		for (int k = minLength; k >= 0; k--) {
			if (words[i].endsWith(words[j].substring(0, k))) {
				return words[j].length() - k;
			}
		}
		return words[j].length();
	}

}
