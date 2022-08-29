package gracefulsoul.problems;

public class DecodeWaysII {

	// https://leetcode.com/submissions/detail/786193044/
	public static void main(String[] args) {
		DecodeWaysII test = new DecodeWaysII();
		System.out.println(test.numDecodings("*"));
		System.out.println(test.numDecodings("1*"));
		System.out.println(test.numDecodings("2*"));
	}

	public int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int length = s.length();
		long[] dp = new long[length + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '*' ? 9 : 1;
		for (int idx = 2; idx < length + 1; idx++) {
			char first = s.charAt(idx - 2);
			char second = s.charAt(idx - 1);
			if (second == '*') {
				dp[idx] += 9 * dp[idx - 1];
			} else if (second != '0') {
				dp[idx] += dp[idx - 1];
			}
			if (first == '*') {
				if (second == '*') {
					dp[idx] += 15 * dp[idx - 2];
				} else if (second <= '6') {
					dp[idx] += 2 * dp[idx - 2];
				} else {
					dp[idx] += dp[idx - 2];
				}
			} else if (first == '1') {
				if (second == '*') {
					dp[idx] += 9 * dp[idx - 2];
				} else {
					dp[idx] += dp[idx - 2];
				}
			} else if (first == '2') {
				if (second == '*') {
					dp[idx] += 6 * dp[idx - 2];
				} else if (second <= '6') {
					dp[idx] += dp[idx - 2];
				}
			}
			dp[idx] %= 1000000007;
		}
		return (int) dp[length];
	}

}
