package gracefulsoul.problems;

public class FriendsOfAppropriateAges {

	// https://leetcode.com/problems/friends-of-appropriate-ages/submissions/889363899/
	public static void main(String[] args) {
		FriendsOfAppropriateAges test = new FriendsOfAppropriateAges();
		System.out.println(test.numFriendRequests(new int[] { 16, 16 }));
		System.out.println(test.numFriendRequests(new int[] { 16, 17, 18 }));
		System.out.println(test.numFriendRequests(new int[] { 20, 30, 100, 110, 120 }));
	}

	public int numFriendRequests(int[] ages) {
		int[] dp = new int[121];
		for (int age : ages) {
			dp[age]++;
		}
		for (int idx = 1; idx <= 120; idx++) {
			dp[idx] += dp[idx - 1];
		}
		int result = 0;
		for (int i = 120, j = 120; i >= 1; i--) {
			while (j > ((0.5 * i) + 7)) {
				j--;
			}
			if (++j <= i) {
				result += (dp[i] - dp[i - 1]) * (dp[i] - dp[j - 1] - 1);
			}
		}
		return result;
	}

}
