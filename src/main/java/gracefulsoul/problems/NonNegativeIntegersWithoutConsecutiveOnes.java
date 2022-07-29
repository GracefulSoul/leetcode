package gracefulsoul.problems;

public class NonNegativeIntegersWithoutConsecutiveOnes {

	// https://leetcode.com/submissions/detail/759813465/
	public static void main(String[] args) {
		NonNegativeIntegersWithoutConsecutiveOnes test = new NonNegativeIntegersWithoutConsecutiveOnes();
		System.out.println(test.findIntegers(5));
		System.out.println(test.findIntegers(1));
		System.out.println(test.findIntegers(2));
	}

	public int findIntegers(int n) {
		int[] dp = new int[32];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int sum = 0;
		int pre = 0;
		for (int idx = 30; idx >= 0; idx--) {
			if ((n & (1 << idx)) != 0) {
				sum += dp[idx];
				if (pre == 1) {
					sum--;
					break;
				}
				pre = 1;
			} else {
				pre = 0;
			}
		}
		return sum + 1;
	}

}
