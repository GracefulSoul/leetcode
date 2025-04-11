package gracefulsoul.problems;

public class CountTheNumberOfPowerfulIntegers {

	// https://leetcode.com/problems/count-the-number-of-powerful-integers/submissions/1602617642/
	public static void main(String[] args) {
		CountTheNumberOfPowerfulIntegers test = new CountTheNumberOfPowerfulIntegers();
		System.out.println(test.numberOfPowerfulInt(1, 6000, 4, "124"));
		System.out.println(test.numberOfPowerfulInt(15, 215, 6, "10"));
		System.out.println(test.numberOfPowerfulInt(1000, 2000, 4, "3000"));
	}

	public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
		return this.numberOfPowerfulInt(finish, limit, s) - this.numberOfPowerfulInt(start - 1, limit, s);
	}

	private long numberOfPowerfulInt(long num, int limit, String s) {
		String str = Long.toString(num);
		int length = str.length() - s.length();
		if (length < 0) {
			return 0;
		} else {
			long[][] dp = new long[length + 1][2];
			dp[length][0] = 1;
			dp[length][1] = str.substring(length).compareTo(s) >= 0 ? 1 : 0;
			for (int i = length - 1; i >= 0; i--) {
				int curr = str.charAt(i) - '0';
				dp[i][0] = (limit + 1) * dp[i + 1][0];
				if (curr <= limit) {
					dp[i][1] = (curr * dp[i + 1][0]) + dp[i + 1][1];
				} else {
					dp[i][1] = dp[i][0];
				}
			}
			return dp[0][1];
		}
	}

}
