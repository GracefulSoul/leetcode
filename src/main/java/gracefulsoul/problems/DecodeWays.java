package gracefulsoul.problems;

public class DecodeWays {

	// https://leetcode.com/submissions/detail/520154233/
	public static void main(String[] args) {
		DecodeWays test = new DecodeWays();
		System.out.println(test.numDecodings("12"));
		System.out.println(test.numDecodings("226"));
		System.out.println(test.numDecodings("0"));
		System.out.println(test.numDecodings("06"));
	}

	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;
		dp[s.length() - 1] = s.charAt(s.length() - 1) != '0' ? 1 : 0;
		for (int idx = s.length() - 2; idx >= 0; idx--) {
			if (s.charAt(idx) != '0') {
				dp[idx] = dp[idx + 1] + (Integer.parseInt(s.substring(idx, idx + 2)) <= 26 ? dp[idx + 2] : 0);
			}
		}
		return dp[0];
	}

}
