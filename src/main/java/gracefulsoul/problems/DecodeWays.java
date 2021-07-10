package gracefulsoul.problems;

public class DecodeWays {

	// https://leetcode.com/submissions/detail/520116082/
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
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				dp[i] = dp[i + 1] + (Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 2] : 0);
			}
		}
		return dp[0];
	}

}
