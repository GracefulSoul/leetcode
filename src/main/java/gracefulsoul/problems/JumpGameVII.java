package gracefulsoul.problems;

public class JumpGameVII {

	// https://leetcode.com/problems/jump-game-vii/submissions/2012112083/
	public static void main(String[] args) {
		JumpGameVII test = new JumpGameVII();
		System.out.println(test.canReach("011010", 2, 3));
		System.out.println(test.canReach("01101110", 2, 3));
	}

	public boolean canReach(String s, int minJump, int maxJump) {
		int length = s.length();
		int jump = 0;
		boolean[] dp = new boolean[length];
		dp[0] = true;
		for (int i = 1; i < length; i++) {
			if (minJump <= i && dp[i - minJump]) {
				jump++;
			}
			if (maxJump < i && dp[i - maxJump - 1]) {
				jump--;
			}
			dp[i] = 0 < jump && s.charAt(i) == '0';
		}
		return dp[length - 1];
	}

}
