package gracefulsoul.problems;

public class StrangePrinter {

	// https://leetcode.com/submissions/detail/802471576/
	public static void main(String[] args) {
		StrangePrinter test = new StrangePrinter();
		System.out.println(test.strangePrinter("aaabbb"));
		System.out.println(test.strangePrinter("aba"));
	}

	public int strangePrinter(String s) {
		int lnegth = s.length();
		int[][] dp = new int[lnegth][lnegth];
		for (int idx = 0; idx < lnegth; idx++) {
			dp[idx][idx] = 1;
			if (idx + 1 < lnegth) {
				dp[idx][idx + 1] = s.charAt(idx) == s.charAt(idx + 1) ? 1 : 2;
			}
		}
		for (int l = 3; l <= lnegth; l++) {
			for (int i = 0; i <= lnegth - l; i++) {
				int j = i + l - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
				}
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j]--;
				}
			}
		}
		return dp[0][lnegth - 1];
	}

}
